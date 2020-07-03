package edu.algorithms.array;

/**
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] stocks = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + maxProfit(stocks));
    }

    /**
     * The points of interest are the consecutive valleys and peaks.
     *
     * Mathematically speaking:
     * Total Profit= sum{i} (height(peak_i)-height(valley_i))
     *
     * The key point is we need to consider every peak immediately following a valley to maximize the profit.
     * In case we skip one of the peaks (trying to obtain more profit), we will end up losing the profit over one of the transactions
     * leading to an overall lesser profit.
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length == 0 || prices.length == 1) {
            return profit;
        }
        int i = 0;
        int peak = prices[0];
        int valley = prices[0];
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i+1]) {
                i++;
            }
            // valley found
            valley=prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i+1]) {
                i++;
            }
            peak = prices[i];
            profit += peak - valley;
        }
        return profit;
    }
}
