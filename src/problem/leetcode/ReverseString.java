package problem.leetcode;

import java.util.Arrays;

//344
public class ReverseString {
    public static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i<j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        char[] t = new char[]{'H','a','n','n','a','h'};

        reverseString(s);
        reverseString(t);
    }
}
