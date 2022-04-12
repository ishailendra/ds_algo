package problem.leetcode;

import java.util.Arrays;

//2216
public class MinimumDeletionsToMakeArrayBeautiful {


    public static int minDeletion2(int[] nums) {
        int i = 0, k = nums.length, counter = 0;

        if(k == 0) return 0;
        while (i<k-1) {
            if(nums[i] == nums[i+1]) {
                System.arraycopy(nums,i+2, nums, i+1, nums.length - i - 2);
                counter++;
                k--;
                continue;
            }
            i+=2;
        }

        System.out.println(Arrays.toString(nums));
         return k%2 == 0 ? counter : counter + 1;

    }

    public static int minDeletion(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if((i - counter) % 2 == 0 && (nums[i] == nums[i+1])) {
                counter++;
            }
        }
        return (nums.length - counter) % 2 + counter;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,5,4,2,4,7,2,3,0,3,0,0,9,7,5,9,4,3,9,9,2,1,6,3,1,0,7,6,6,6,0,1,7,1,9,4,9,3,3,4,5,0,3,8,7,1,8,4,5};
//        int[] nums = new int[]{1,1,2,2,3,3};

//        System.out.println(arr.length);
//        System.out.println(minDeletion2(arr));
        System.out.println(minDeletion(arr));
    }
}
