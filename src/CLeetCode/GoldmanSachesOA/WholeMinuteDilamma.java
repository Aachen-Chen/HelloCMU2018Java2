package CLeetCode.GoldmanSachesOA;

import java.util.*;

public class WholeMinuteDilamma {
    public static int wholeMinDilamma(List<Integer> inputs) {
        if (inputs == null || inputs.size() <= 1) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer time: inputs) {
            int remainder = time % 60;
            if (remainder != 0) {
                if (map.containsKey(remainder)) {
                    map.put(remainder, map.get(remainder) + 1);
                } else {
                    map.put(remainder, 1);
                }
            }
        }

        int count = 0;
        for (Integer key: map.keySet()) {
            int subset = 60 - key;
            if (map.get(subset) != null) {
                count += map.get(subset);
                if (subset == key) {
                    count--;
                }

            }
        }

        return count / 2;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10,20,60,50,40,30,30,30);
        int output = wholeMinDilamma(input);
        System.out.println(output);

    }
}
