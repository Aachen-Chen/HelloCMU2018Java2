package CLeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;


public class Solution {
    List<List<String>> res = new ArrayList<>();
    HashMap<String, List<String>> map = new HashMap<>();

    public List<List<String>> findLadders(
        String beg, String end, List<String> wordL)
    {
        if(wordL==null || wordL.size()==0) return res;
        HashSet<String> dic = new HashSet<>(wordL);
        if(!dic.contains(end)) return res;
        HashSet<String> sta = new HashSet<>();
        HashSet<String> sto = new HashSet<>();
        List<String> path = new ArrayList<>();
        sta.add(beg);
        sto.add(end);
        path.add(beg);

        bfs(sta, sto, dic, false);
        dfs(beg, end, path);

        return res;
    }

    private void bfs(
        HashSet<String> sta, HashSet<String> sto, HashSet<String> dic, boolean reverse)
    {
        // If have nothing to start with
        if(sta.size()==0) return;
        // Ok. Traverse from both side of map.
        if(sta.size()>sto.size()) {
            bfs(sto, sta, dic, !reverse); return;
        }

        HashSet<String> next = new HashSet<>();
        dic.removeAll(sta);
        boolean finished = false;
        for(String s: sta){
            char[] arr=s.toCharArray();
            for(int i=0; i<arr.length; i++){
                char tmp = arr[i];
                for(char c='a'; c<='z'; c++){
                    if(c == tmp) continue;
                    arr[i] = c;
                    String nStr = new String(arr);
                    // Try out new String
                    if(dic.contains(nStr)){
                        // If reach the stop elements, stop bfs.
                        if(sto.contains(nStr)) finished = true;
                        // Record current location
                        else next.add(nStr);
                        // Fill the map
                        String key = reverse? nStr:s;
                        String val = reverse? s:nStr;
                        if(!map.containsKey(key))
                            map.put(key, new ArrayList<>());
                        map.get(key).add(val);
                    }
                }
                arr[i]=tmp;
            }
        }
        if (!finished) bfs(next, sto, dic, reverse);
    }

    private void dfs(
        String beg, String end, List<String> path)
    {

    }



}