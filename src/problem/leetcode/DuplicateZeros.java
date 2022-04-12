package problem.leetcode;

import java.util.Arrays;

//1089
public class DuplicateZeros {
    public static int[] duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length-1; ) {
            if(arr[i]  == 0) {
                System.arraycopy(arr, i+1, arr, i+2, arr.length - i-2);
                arr[i+1] = 0;
                i += 2;
                continue;
            }
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 1,0,2,3,0,4,5,0};
        arr = duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
