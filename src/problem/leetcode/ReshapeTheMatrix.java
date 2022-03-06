package problem.leetcode;

import java.util.Arrays;


//566
public class ReshapeTheMatrix {

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;

        if(r*c != m*n){
            return mat;
        }

        c = (m*n)/r == 0 ? 1 : (m*n)/r;
        int[][] newMat = new int[r][c];

        int row = 0, column = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Number: "+ mat[i][j]);
                if (column == c) {
                    row++;
                    column = 0;
                }
                newMat[row][column] = mat[i][j];
                column++;
            }
        }


        return newMat;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,2},{3,4}};//{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
        mat = matrixReshape(mat, 1, 4);
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

}
