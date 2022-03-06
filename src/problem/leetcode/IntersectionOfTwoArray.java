package problem.leetcode;

import java.util.*;

//349
public class IntersectionOfTwoArray {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> indices = new HashSet<>();

        if(nums1.length <= nums2.length) {
            Arrays.sort(nums2);

            for (int a: nums1) {
                if(Arrays.binarySearch(nums2, a)>-1){
                    indices.add(a);
                }
            }
        }
        else if(nums1.length > nums2.length) {
            Arrays.sort(nums1);

            for (int a: nums2) {
                if(Arrays.binarySearch(nums1, a)>-1){
                    indices.add(a);
                }
            }
        }
        int[] arr = new int[indices.size()];
        int i = 0;
        for (int a: indices) {
            arr[i] = a;
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
