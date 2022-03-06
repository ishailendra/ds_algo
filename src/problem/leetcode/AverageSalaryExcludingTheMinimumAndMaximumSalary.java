package problem.leetcode;

import java.util.Arrays;

//1491
public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        double sum = 0;

        for(int a : salary) {
            if(a<min) {
                min = a;
            }

            if(a>max) {
                max = a;
            }

            sum += a;
        }

        return (sum-min-max)/(salary.length-2);
    }
}
