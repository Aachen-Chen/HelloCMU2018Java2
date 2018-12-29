package CLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {

    // TODO: Solution:
    // 181228: sort, then for each index, 2sum the remain.
    //      fix two index, then iter another, this is n^3.
    //      fix one index, then 2sum the remain, this is n^2
    public static List<List<Integer>> threeSum181228(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(nums[i]>0) break;
            if(i>0 && nums[i-1]==nums[i]) continue;
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                if(nums[l]+nums[r]<0-nums[i]){ l++; }
                else if(nums[l]+nums[r]>0-nums[i]){ r--; }
                else{
                    if(res.size() == 0
                            || res.get(res.size()-1).get(0)!=nums[i]
                            || res.get(res.size()-1).get(1)!=nums[l]
                    ){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]); temp.add(nums[l]); temp.add(nums[r]);
                        res.add(temp);
                    }
                    l++; r--;
                }
            }
        }
        return res;
    }
}


