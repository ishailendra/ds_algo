package problem.leetcode;

//191
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeight2(int n) {
        String bits = Integer.toBinaryString(n);
        int counter = 0;
        for(int i = 0; i<bits.length(); i++) {
            if('1' == bits.charAt(i)) counter++;
        }

        return counter;
    }

    public int hammingWeight3(int n) {
        int count = 0;
        while(n != 0) {
            //This expression will make the least significant bit (LSB) as 0.
            //For eg -> 13 = 1101
            //          12 = 1100
            // will give ->  1000
            // Hence the Time complexity would also be optimized because it will
            // only check the number of 1's rather than going to every index.
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
