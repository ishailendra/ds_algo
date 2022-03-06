package problem.leetcode;

import java.util.*;
import java.util.stream.Collectors;


//383
public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) {
            return false;
        }

        List<Character> ransom = ransomNote.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> mag = magazine.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        for (int i = 0; i <ransom.size() ; i++) {
            int ransomFreq = Collections.frequency(ransom, ransom.get(i));
            int magazineFreq = Collections.frequency(mag, ransom.get(i));
            if(ransomFreq > magazineFreq) {
                return false;
            }
        }
        return true;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {

        if(ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> ransom = new HashMap<>();
        Map<Character, Integer> mag = new HashMap<>();
        int i = 0, j = 0;
        //boolean flag = false;
        while(i<ransomNote.length() || j<magazine.length()) {
            if(i<ransomNote.length()) {
                if(ransom.get(ransomNote.charAt(i)) != null){
                    ransom.put(ransomNote.charAt(i), ransom.get(ransomNote.charAt(i))+1);
                }
                else {
                    ransom.put(ransomNote.charAt(i), 1);
                }
                i++;
            }

            if(j<magazine.length()) {
                if(mag.get(magazine.charAt(j)) != null){
                    mag.put(magazine.charAt(j), mag.get(magazine.charAt(j))+1);
                }
                else {
                    mag.put(magazine.charAt(j), 1);
                }
                j++;
            }
        }
        for(Map.Entry<Character, Integer> entry: ransom.entrySet()) {
            if(mag.get(entry.getKey()) == null || mag.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }

    public static boolean canConstruct3(String ransomNote, String magazine){
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];

        for(int i = 0;i < ransomNote.length();i++){
            int pos = ransomNote.charAt(i) - 'a';

            hash1[pos]++;
        }

        for(int i = 0;i < magazine.length();i++){
            int pos = magazine.charAt(i) - 'a';

            hash2[pos]++;
        }

        for(int i = 0;i < ransomNote.length();i++){
            int pos = ransomNote.charAt(i) - 'a';

            if(hash2[pos] < hash1[pos]){
                return false;
            }
        }

        return true;
    }

    public static boolean canConstruct4(String ransomNote, String magazine){
        List<Character> magList = new ArrayList<Character>();

        for(char c : magazine.toCharArray()){
            magList.add(c);
        }

        for(char c: ransomNote.toCharArray()){
            if(!magList.remove(Character.valueOf(c))){
                return false;
            }
        }
        return true;

    }


    public static void main(String[] args) {
        System.out.println(canConstruct4("aa", "ab"));
        System.out.println(canConstruct4("a", "b"));
        System.out.println(canConstruct4("aa", "aab"));

        System.out.println(canConstruct4("bg","efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
    }
}
