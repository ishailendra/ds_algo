package tester;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i] == key) {
                int newLow = i-k < 0 ? 0 : i-k;
                int newHigh = i+k+1 <= len ? i+k+1 : len;

                if(newLow<low){
                    low = newLow;
                }
                if(newHigh>high){
                    high = newHigh;
                }

            }
        }

        return IntStream.range(low,high).boxed().collect(Collectors.toList());

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,9,1,3,9,5};

        System.out.println(findKDistantIndices(nums, 9, 1).toString());
    }
}
