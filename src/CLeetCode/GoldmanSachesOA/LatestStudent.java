package CLeetCode.GoldmanSachesOA;
import java.util.*;

public class LatestStudent {
    public static String latestStudent(List<List<String>> input) {
        if (input == null) {
            return null;
        }

        Map<String, List<Integer>> classLate = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            List<String> cur = input.get(i);
            String date = cur.get(0);
            int classTime = Integer.parseInt(cur.get(2));
            int arrvTime = Integer.parseInt(cur.get(3));
            int lateDiff = arrvTime > classTime ? arrvTime - classTime : 0;
            if (classLate.containsKey(date)) {
                List<Integer> lateList = classLate.get(date);
                lateList.add(lateDiff);
                classLate.put(date, lateList);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(lateDiff);
                classLate.put(date, newList);
            }
        }

        Map<String, Integer> avgLate = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry: classLate.entrySet()) {
            String date = entry.getKey();
            List<Integer> lateSum = entry.getValue();
            int size = lateSum.size();
            int sum = 0;
            for (Integer value: lateSum) {
                sum += value;
            }

            avgLate.put(date, sum / size);
        }

        Map<String, Integer> personLate = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            List<String> cur = input.get(i);
            String person = cur.get(1);
            int classTime = Integer.parseInt(cur.get(2));
            int arrvTime = Integer.parseInt(cur.get(3));
            int lateDiff = arrvTime > classTime ? arrvTime - classTime : 0;
            int avg = avgLate.get(cur.get(0));
            int relativeLate = lateDiff > avg ? lateDiff - avg : 0;
            if (personLate.containsKey(person)) {
                personLate.put(person, personLate.get(person) + relativeLate);
            } else {
                personLate.put(person, relativeLate);
            }
        }

        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        };

        List<Map.Entry<String, Integer>> list = new ArrayList<>(personLate.entrySet());
        Collections.sort(list, comparator);

        return list.get(0).getKey();
    }

    public static void main(String[] args) {
        List<List<String>> input1 = new ArrayList<>();
        /**
        input1.add(Arrays.asList("06-22","Chuck","540","540"));
        input1.add(Arrays.asList("06-23","Debby","540","555"));
        input1.add(Arrays.asList("06-23","Chuck","540","540"));
        input1.add(Arrays.asList("06-23","Doug","600","630"));
        input1.add(Arrays.asList("06-24","Chuck","600","600"));
        input1.add(Arrays.asList("06-24","Doug","600","600"));**/
        input1.add(Arrays.asList("09-01","Arlene","540","570"));
        input1.add(Arrays.asList("09-01","Bobby","540","543"));
        input1.add(Arrays.asList("09-01","Caroline","540","530"));
        input1.add(Arrays.asList("09-02","Arlene","540","580"));
        input1.add(Arrays.asList("09-02","Bobby","540","580"));
        input1.add(Arrays.asList("09-02","Caroline","540","595"));
        System.out.println(latestStudent(input1));
    }


}
