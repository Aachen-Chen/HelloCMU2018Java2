package GoldmanSachesOA;

import java.util.Arrays;
import java.util.List;

public class MaximumDifferenceArray {
    public static int maximumDiff(List<Integer> inputs) {
        int min = Integer.MAX_VALUE;
        int diff = Integer.MIN_VALUE;
        for (Integer val: inputs) {
            if (val % 2 != 0) {
                min = Math.min(min, val);
            } else if (val - min > 0){
                diff = Math.max(diff, val - min);
            }
        }

        return diff;
    }

    public static void main(String[] args) {
        List<Integer> inputs = Arrays.asList(1, 7, 2, 4, 6, 3, 5);
        System.out.println(maximumDiff(inputs));
    }
}
