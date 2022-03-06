package problem.leetcode;

import java.util.ArrayList;
import java.util.List;


//118
public class PascalsTriangel {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        List<Integer> row;


        List<Integer> prev = null;
        int k = 0;
        for (int i = 1; i <= numRows; i++) {
            row = new ArrayList<>();
            for (int j = 0; j < i; j++) {

                if(j == 0 || j == i-1) {
                    row.add(1);
                }
                else {
                    row.add(prev.get(j-1)+prev.get(j));
                }

            }
            prev = row;
            pascalTriangle.add(row);
            k = 0;
        }
        return pascalTriangle;
    }

    public static void main(String[] args) {
        List<List<Integer>> pascal = generate(2);
        for (List<Integer> list: pascal) {
            System.out.println(list.toString());
        }
    }
}
