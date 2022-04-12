package problem.leetcode;

//27
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {

        int i = 0, j = 0;

        while (i<nums.length) {
            if(nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        removeElement(arr, 1);
    }
}
