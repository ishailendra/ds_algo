package problem.leetcode;


//1281
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;

        while(n>0) {
            int rem = n%10;
            n = n/10;

            product *= rem;
            sum += rem;
        }

        return (product - sum);
    }
}
