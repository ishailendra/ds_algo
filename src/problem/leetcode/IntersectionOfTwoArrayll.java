package problem.leetcode;

import java.util.*;


//350
public class IntersectionOfTwoArrayll {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> indices = new ArrayList<>();
        int[] arr  = new int[]{};
        int i = 0;

        if(nums1.length <= nums2.length) {
            Arrays.sort(nums2);

            for (int j = 0; j<nums1.length; j++) {
                int index = linearSearch(nums2, nums1[j]);
                if(index>-1){
                    indices.add(nums2[index]);
                    nums2[index] = -1;
                }
            }
            arr  = new int[indices.size()];
            for (int a: indices) {
                arr[i] = a;
                i++;
            }
        }
        else if(nums1.length > nums2.length) {
            Arrays.sort(nums1);

            for (int j = 0; j<nums2.length; j++) {
                int index = linearSearch(nums1, nums2[j]);
                if(index>-1){
                    indices.add(nums1[index]);
                    nums1[index] = -1;
                }
            }
            arr  = new int[indices.size()];
            for (int a: indices) {
                arr[i] = a;
                i++;
            }
        }


        return arr;
    }

    public static int linearSearch(int arr[], int key) {
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2};
        int[] arr2 = {1,1};
        System.out.println(Arrays.toString(intersect(arr, arr2)));
    }
}

