package problem.leetcode;

import java.util.*;


//36
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        Map<Character, Integer> block1 = new HashMap<>();
        Map<Character, Integer> block2 = new HashMap<>();
        Map<Character, Integer> block3 = new HashMap<>();
        Map<Character, Integer> row;
        Map<Character, Integer> col;

        for (int i = 0; i < 9; i++) {
            row = new HashMap<>();
            col = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                char a = board[i][j];
                char b = board[j][i];

                if(a != '.') {
                    if (row.get(a) == null) {
                        row.put(a, 0);
                    } else {
                        return false;
                    }

                    if(j<3) {
                        if(block1.get(a) == null){
                            block1.put(a, 0);
                        }
                        else {
                            return false;
                        }
                    }
                    else if(j>=3 && j<6) {
                        if(block2.get(a) == null){
                            block2.put(a, 0);
                        }
                        else {
                            return false;
                        }
                    }
                    else if(j>=6 ) {
                        if(block3.get(a) == null){
                            block3.put(a, 0);
                        }
                        else {
                            return false;
                        }
                    }
                }
                if(b != '.') {
                    if (col.get(b) == null) {
                        col.put(b, 0);
                    } else {
                        return false;
                    }
                }
            }
            if((i+1)%3 == 0) {
                block1 = new HashMap<>();
                block2 = new HashMap<>();
                block3 = new HashMap<>();
            }
        }
        return true;
    }

    // Ans Credit - https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings
    public static boolean isValidSudoku2(char[][] board) {
        Set<String> seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'.',  '2',  '.',  '.',  '.',  '.',  '.',  '.',  '.'}
                ,{'.',  '.',  '.',  '.',  '.',  '.',  '5',  '.',  '1'}
                ,{'.',  '.',  '.',  '.',  '.',  '.',  '8',  '1',  '3'}
                ,{'4',  '.',  '9',  '.',  '.',  '.',  '.',  '.',  '.'}
                ,{'.',  '.',  '.',  '.',  '.',  '.',  '.',  '.',  '.'}
                ,{'.',  '.',  '2',  '.',  '.',  '.',  '.',  '.',  '.'}
                ,{'7',  '.',  '6',  '.',  '.',  '.',  '.',  '.',  '.'}
                ,{'9',  '.',  '.',  '.',  '.',  '4',  '.',  '.',  '.'}
                ,{'.',  '.',  '.',  '.',  '.',  '.',  '.',  '.',  '.'}};
        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku2(board));
    }



}
