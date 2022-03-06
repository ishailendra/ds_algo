package problem.leetcode;

import java.io.*;


//121
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0; long iteration = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                iteration++;
                if((prices[j] - prices[i]) > maxProfit){
                    maxProfit = prices[j] - prices[i];

                }
            }
        }
        System.out.println("Iteration: "+iteration + " Prices count: "+prices.length);
        return  maxProfit;

    }

    public static int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE, maxProfit = 0;
        for(int i = 0; i<prices.length; i++) {
            if(prices[i]<min) {
                min = prices[i];
            }
            else if((prices[i]-min)>maxProfit) {
                maxProfit = prices[i]-min;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) throws IOException {
//        int[] prices = new int[]{7,1,5,3,6,4};//{7,6,4,3,1};

        // load data from file
        BufferedReader br = new BufferedReader(new FileReader("D:\\Projects\\DSAlgo\\testcase.txt"));

        // read entire line as string
        String line = br.readLine();

        // checking for end of file
        //while (line != null) {
        //    listOfStrings.add(line);
        //    line = bf.readLine();
        //}
        String[] arr = line.split(",");
        // closing bufferreader object
        br.close();

        int[] prices = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            prices[i] = Integer.parseInt(arr[i]);
        }

        long start = System.currentTimeMillis();
        System.out.println(maxProfit2(prices));
        long end = System.currentTimeMillis();
        System.out.println("Time "+ (end-start)/1000);

    }
}
