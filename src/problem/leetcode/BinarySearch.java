package problem.leetcode;

public class BinarySearch {

    public static int binarySearch(int nums[], int target) {
        int min = 0, max = nums.length-1;

        while(min<=max) {
            int mid = min + (max-min)/2;

            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target) {
                min = mid+1;
            }
            else {
                max = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,7,8,9,10,11,24};
        System.out.println(binarySearch(arr,1));
        System.out.println(binarySearch(arr,4));
        System.out.println(binarySearch(arr,5));
        System.out.println(binarySearch(arr,24));
        System.out.println(binarySearch(arr,25));
    }
}
