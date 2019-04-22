package CLeetCode;

import java.util.*;

public class lc381 {

}

class RandomizedCollection {

    Map<Integer, List<Integer>> map;
    List<Integer> list;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val))  map.put(val, new ArrayList<>());
        map.get(val).add(list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))  return false;

        List<Integer> posList = map.get(val);
        int pos = posList.get(posList.size() -1);
        posList.remove(posList.size() -1);

        if (posList.size() ==0)  map.remove(val);
        if (pos == list.size() -1) {
            list.remove(pos);
            return true;
        }

        int last = list.get(list.size() -1);
        List<Integer> lastList= map.get(last);
        lastList.remove(lastList.size() -1);
        lastList.add(0, pos);
        Collections.sort(lastList);
        list.set(pos, last);
        list.remove(list.size() -1);

        return true;

    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}

