package CLeetCode;

import java.util.Arrays;

public class PartitionEqualSubsetSum416 {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length < 2) return false;

        // check if sum is odd, cannot divide
        int sum = 0;
        for(int i : nums) {sum = sum + i;}
        if(sum % 2 == 1) return false;

        sum = sum /2;
        int n = nums.length;
        // Notice: for row i, it means "possible with FIRST i ITEMS", NOT item i alone.
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) { Arrays.fill(dp[i], false); }

        // for sum=0, select 0 item, ok.
        dp[0][0] = true;
        // for first column, which is sum=0, all item can be selected right, if you select 0 item.
        for (int i = 1; i < n + 1; i++) { dp[i][0] = true; }
        // for first row, if need sum to be more than 0, cannot select 0 item.
        for (int j = 1; j < sum + 1; j++) { dp[0][j] = false; }

        // for each row
        for (int i = 1; i < n + 1; i++) {
            // for each item
            for (int j = 1; j < sum + 1; j++) {
                // we are at i, for according item (nums.length = dp.length-1)
                // if we want to get j, and i > j, it is impossible: you cannot divide i.
                if (j >= nums[i - 1]) {
                    // if now you have j>=i, this position is possibile if:
                    dp[i][j] = (
                            // if FIRST i ITEMS could, it could. If first i cannot, see below
                            dp[i - 1][j]
                            // or, if after substracting this num from j (j - nums[i - 1]), is possible by previous items (i-1)
                            || dp[i - 1][j - nums[i - 1]]
                    );
                }
                else {
                    // but if previous items could, fine, this one could, too.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // finally: return if it is possible to:
        // achieve the "half" number
        // with first n (which is all) items.
        return dp[n][sum];
    }

}

