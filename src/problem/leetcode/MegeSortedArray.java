package problem.leetcode;

import java.util.Arrays;


//88
public class MegeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;

        while(i<nums1.length && j< nums2.length) {
            if(nums1[i] <= nums2[j] && m > i) {
              i++;
            }
            else if(nums1[i] > nums2[j] && m > i) {
                System.arraycopy(nums1, i, nums1, i+1, nums1.length - i-1);
                nums1[i] = nums2[j];
                i++;
                j++;
                m++;
            }
            else {
                System.arraycopy(nums2, j, nums1, i, nums2.length - j);
                break;
            }
        }

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums1 = {4,5,6, 0, 0, 0};
        int[] nums2 = {1,2,3};

        merge(nums1,3, nums2, 3);

    }
}
