package CLeetCode;


import java.util.*;

// 181101
public class ThreeSum15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        int len = nums.length;
        if (len < 3) {
            return ans;
        }

        Arrays.sort(nums);
        int lastNeg = Arrays.binarySearch(nums, 0);
        int firstPos = lastNeg;
        int numZero;

        if (lastNeg < 0) {
            // no zeros, indices: [0..lastNeg,firstPos..N)
            numZero = 0;
            lastNeg = ((-lastNeg) - 1) - 1; // retrieve insertion point from Java binarySearch
            firstPos = lastNeg + 1; // firstPos is immediately after lastNeg
        } else {
            // zeros exist, indices: [0..lastNeg..zeros..firstPos..N)
            while (lastNeg > -1 && nums[lastNeg] == 0)
                lastNeg--;
            while (firstPos < len && nums[firstPos] == 0)
                firstPos++;
            numZero = firstPos - lastNeg - 1;
        }
        int min = nums[0];
        int max = nums[len - 1];
        // hash[i] = j means there are j instances of (i + min)
        int[] hash = new int[max - min + 1];
        for (int v : nums) {
            hash[v - min]++;
        }

        // Case 0: (0,0,0)
        if (numZero >= 3) {
            ans.add(Arrays.asList(0, 0, 0));
        }

        // Case 1: (-X,0,X)
        if (numZero > 0) {
            for (int i = firstPos; i < len; i++) {
                // skip redundant values
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
                int need = 0 - (nums[i] + min);
                if (need >= 0 && hash[need] > 0) {
                    ans.add(Arrays.asList(0, nums[i], -nums[i]));
                }
            }
        }

        // Case 2: 1 positive, 2 negative
        for (int i = firstPos; i < len; i++) {
            // ignore repeated values
            if (i > firstPos && nums[i] == nums[i - 1]) {
                continue;
            }
            int half;
            if (nums[i] % 2 != 0) {
                // round up
                half = -(nums[i] + 1) / 2;
            } else {
                // Subcase: (x, -x/2, -x/2)
                half = -nums[i] / 2;
                if (half >= min && hash[half - min] > 1) {
                    ans.add(Arrays.asList(nums[i], half, half));
                }
            }
            for (int j = lastNeg; j >= 0 && nums[j] > half; j--) {
                // Note: nums[j] > half prevents repeated cases. E.g., (4,-1,-3) and (4,-3,-1)
                // ignore repeated values
                if (j < lastNeg && nums[j] == nums[j + 1]) {
                    continue;
                }
                int need = 0 - (nums[i] + nums[j]);
                if (need >= min && hash[need - min] > 0)
                    ans.add(Arrays.asList(nums[i], nums[j], need));
            }
        }

        // Case 3: 1 negative, 2 positive
        for (int i = lastNeg; i > -1; i--) {
            if (i < lastNeg && nums[i] == nums[i + 1]) {
                continue;
            }
            int half;
            if (nums[i] % 2 != 0) {
                half = -(nums[i] - 1) / 2;
            } else {
                half = -nums[i] / 2;
                // Subcase: (x, -x/2, -x/2), x < 0
                if (half - min < hash.length && hash[half - min] > 1)
                    ans.add(Arrays.asList(nums[i], half, half));
            }
            for (int j = firstPos; j < len && nums[j] < half; j++) {
                if (j > firstPos && nums[j] == nums[j - 1]) {
                    continue;
                }
                int need = 0 - (nums[i] + nums[j]);
                if (need <= max && hash[need - min] > 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], need));
                }
            }
        }

        return ans;
    }

    public List<List<Integer>> sol2(int[] nums) {
        // n^2
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int lo = i + 1;
                int hi = nums.length - 1;
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == -nums[i]) {
                        result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        lo++;
                        hi--;
                        while (lo < hi && nums[lo-1] == nums[lo]) lo++;
                        while (hi > lo && nums[hi+1] == nums[hi]) hi--;
                    }
                    else if (nums[lo] + nums[hi] < -nums[i]) {
                        lo++;
                    }
                    else {
                        hi--;
                    }
                }
            }
        }
        return result;
    }

    private List<List<Integer>> sol1(int[] nums) {
        // Failed. Duplicate result. just practice Collections
        Map<Integer, HashSet<Integer>> dict = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int k = nums[i]+nums[j];
                if(dict.containsKey(k)) {
                    if(!dict.get(k).contains(nums[i]) && !dict.get(k).contains(nums[j]))
                        dict.get(k).add(nums[i]);
                }
                else {
                    HashSet<Integer> s = new HashSet<>();
                    s.add(nums[i]);
                    dict.put(k, s);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(dict.containsKey(-nums[i])){
                for (Integer j: dict.get(-nums[i])) {
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i], j, 0-nums[i]-j)));
                }
            }
        }
        return result;
    }
}