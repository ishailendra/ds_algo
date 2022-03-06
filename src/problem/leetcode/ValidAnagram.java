package problem.leetcode;


//242
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] hash1 = new int[26];
        int[] hash2 = new int[26];

        int i = 0;
        while (i < s.length()) {

            int pos1 = s.charAt(i) - 'a';
            hash1[pos1]++;

            int pos2 = t.charAt(i) - 'a';
            hash2[pos2]++;

            i++;
        }


        for (int k = 0; k < 26; k++) {
            if (hash1[k] != hash2[k]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
