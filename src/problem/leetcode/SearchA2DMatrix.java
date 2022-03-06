package problem.leetcode;

import java.util.Arrays;


//74
public class SearchA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("Matrix: "+ Arrays.toString(matrix[i]) + " Last Value: "+matrix[i][matrix[i].length-1]);
            if(matrix[i][matrix[i].length-1]>=target) {
                if (Arrays.binarySearch(matrix[i], target) > -1)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix, 3));
    }
}
