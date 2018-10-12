package GoldmanSachesOA;

import CLeetCode.DynamicProgrammingTag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSliceWeight implements DynamicProgrammingTag {
    private static int MinSliceWeight (List<List<Integer>> Matrix){
        if (Matrix==null || Matrix.size()==0 ) return 0;

        int n = Matrix.size();
        int[][] dp = new int[n][n];

        // copy first row of Matrix to dp
        for (int k = 0; k < n; k++) dp[0][k] = Matrix.get(0).get(k);


        // starting from second row
        for (int i = 1; i < n; i++) {
            // for every element
            for (int j = 0; j < n; j++) {
                // if at left most, Mij + min(two element above)
                if (j==0) dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + Matrix.get(i).get(j);
                // if at right most, same
                else if (j==n-1) dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + Matrix.get(i).get(j);
                else dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j+1]), dp[i-1][j-1]) + Matrix.get(i).get(j);
            }
        }

        // now smallest cost is at bottom.
        int path = Integer.MAX_VALUE;
        for (int k=0; k < n; k++) {
            path = Math.min(path, dp[n-1][k]);
//            System.out.print(dp[n-1][k]+" ");
        }

        return path;
    }

    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>();
        List<Integer> c = Arrays.asList(1, 2, 3);
        List<Integer> d = Arrays.asList(6, 5, 4);
        List<Integer> e = Arrays.asList(7, 8, 9);
        inputs.add(c);
        inputs.add(d);
        inputs.add(e);
        System.out.println(MinSliceWeight(inputs));
    }
}
