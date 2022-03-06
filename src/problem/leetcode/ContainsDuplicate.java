package problem.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//217
public class ContainsDuplicate {

    // Big O - nlog n
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null){
                map.put(nums[i], 1);
            }
            else{
                map.put(nums[i], map.get(nums[i]+1));
                if(map.get(nums[i]) > 1) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate2(nums));
    }
}
