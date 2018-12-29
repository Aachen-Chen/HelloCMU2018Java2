package CLeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    // TODO: Solutions:
    // 2018.10: sort array, then iterate, then iterate to find original index
    // 181228: array -> hashmap, then iterate.

    // TODO: Connercase:
    // 181228: {3,2,4} target 6, notice [0, 0], because 3+3=6

    public int[] twoSum201810(int[] nums, int target) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int l=0; int r = nums.length-1;
        while(l<r){
            if(sorted[l]+sorted[r] < target){
                l++; continue;
            }
            if(sorted[l]+sorted[r] > target){
                r--; continue;
            }
            else{
                for(int i=0; i<nums.length; i++){
                    if(nums[i] == sorted[r]){ r = i; break;}
                }
                for(int i=0; i<nums.length; i++){
                    if(i!=r && nums[i] == sorted[l]){ l = i; break;}
                }
                int[] res =new int[]{l, r};
                Arrays.sort(res);
                return res;
            }
        }
        return new int[2];
    }

    public int[] twoSum181228(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){ map.put(nums[i], i); }
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                int i2 = map.get(target - nums[i]);
                if(i2==i) continue;
                return (i<i2?
                        new int[]{i, i2}:
                        new int[]{i2, i} );
            }
        }
        return null;
    }
}