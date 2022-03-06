package problem.leetcode;

//387
public class FirstUniqueCharacterInAString {

    public static int firstUniqChar(String s) {

        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            String str = s.substring(0, i) + s.substring(i+1);
            if(!str.contains(c+"")) {
                return i;
            }

        }
        return -1;
    }

    public static int firstUniqChar2(String s) {

        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(s.indexOf(c) == s.lastIndexOf(c)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(firstUniqChar("aabbccd"));
        System.out.println("abc".substring(0,1) +"  "+"abc".substring(2));
    }
}
