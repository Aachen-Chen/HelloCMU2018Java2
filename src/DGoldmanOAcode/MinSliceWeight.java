package GoldmanSachesOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSliceWeight {
    public static int MinSliceWeight (List<List<Integer>> Matrix){
        int n = Matrix.size();

        if (Matrix == null || n == 0) {
            return 0;
        }


        int[][] dp = new int[n][n];

        for (int k = 0; k < n; k++) {
            dp[0][k] = Matrix.get(0).get(k);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + Matrix.get(i).get(j);
                } else if (j == n - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + Matrix.get(i).get(j);
                } else {
                    int min = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                    dp[i][j] = Math.min(min, dp[i - 1][j - 1]) + Matrix.get(i).get(j);
                }
            }
        }

        int path = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            path = Math.min(path, dp[n - 1][k]);
        }

        return path;
    }

    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>();
        List<Integer> c = Arrays.asList(1, 2, 3);
        List<Integer> d = Arrays.asList(4, 5, 6);
        List<Integer> e = Arrays.asList(7, 8, 9);
        inputs.add(c);
        inputs.add(d);
        inputs.add(e);
        System.out.println(MinSliceWeight(inputs));
    }
}
