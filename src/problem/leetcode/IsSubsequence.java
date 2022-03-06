package problem.leetcode;

//392
public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        if(s.isEmpty()){
            return true;
        }
        for(char c: t.toCharArray()) {
            if(c == s.charAt(i)) {
                i++;
            }
            if(i == s.length())
                return true;
        }

        return false;
    }

    public static boolean isSubsequence2(String s, String t) {
        String regex = ".*";
        int i = 0;
        while(i<s.length()){
            regex += s.charAt(i)+".*";
            i++;
        }

        return t.matches(regex);
    }

    public static void main(String[] args) {
        String s = "b"; //"rjufvjafbxnbgriwgokdgqdqewn";
        String t = "abc"; //"mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq";

        long start, end;
        start = System.currentTimeMillis();
        System.out.println(isSubsequence(s,t));
        end = System.currentTimeMillis();
        System.out.println("Time: "+(end-start));
        System.out.println("*****************************************************************************************");
        start = System.currentTimeMillis();
        System.out.println(isSubsequence2(s,t));
        end = System.currentTimeMillis();
        System.out.println("Time: "+(end-start));
    }

}
