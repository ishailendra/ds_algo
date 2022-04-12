package problem.leetcode;

import java.util.*;

//2215
public class FindTheDifferenceOfTwoArrays {

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> ans1 = new HashSet<>();
        Set<Integer> ans2 = new HashSet<>();
        for (int i = 0, j = 0; i < nums1.length || j < nums2.length; ) {

            if(i < nums1.length) {
                if(Arrays.binarySearch(nums2, nums1[i]) < 0){
                       ans1.add(nums1[i]);
                }
                i++;
            }

            if(j < nums2.length) {
                if(Arrays.binarySearch(nums1, nums2[j]) < 0){
                    ans2.add(nums2[j]);
                }
                j++;
            }
        }

        answer.add(new ArrayList<>(ans1));
        answer.add(new ArrayList<>(ans2));

        return answer;
    }

    public static void main(String[] args) {
        int nums1[] = new int[]{1,2,3};
        int nums2[] = new int[]{2,4,6};
        int nums3[] = new int[]{1,2,3,3};
        int nums4[] = new int[]{1,1,2,2};

        List<List<Integer>> ans1 = findDifference(nums1, nums2);
        List<List<Integer>> ans2 = findDifference(nums3, nums4);

        for (List<Integer> l1: ans1) {
            for (int a: l1) {
                System.out.print(a+"  ");
            }

            System.out.println();
        }
        System.out.println("*****************");

        for (List<Integer> l1: ans2) {
            for (int a: l1) {
                System.out.print(a+"  ");
            }
            System.out.println();
        }
    }
}
