package problem.leetcode;

import java.util.HashMap;
import java.util.Map;


//1
public class TwoSum {

    // O(n^2)
    public static void twoSum(int[] nums, int target) {
        for(int i = 0; i<nums.length; i++) {
            for(int j = 1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    System.out.println("Indices: "+i + ";    "+j);
                    break;
                }
            }
        }
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0; i<nums.length; i++) {
           if(map.get(nums[i]) != null) {
               arr = new int[]{i, map.get(nums[i])};
           }
           else {
               map.put(target - nums[i], i);
           }
        }
        return arr;
    }
}
