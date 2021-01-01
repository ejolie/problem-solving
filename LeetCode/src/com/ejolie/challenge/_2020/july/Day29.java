package com.ejolie.challenge._2020.july;

/**
 * Day29. Best Time to Buy and Sell Stock with Cooldown
 * <p>
 * dp[len][2]
 * case 1: I have a stock on day i, dp[i][1] max of the below
 * - I bought it today
 * : dp[i-2][0] - prices[i]
 * - I am carry forwarding
 * : dp[i-1][1]
 * case 2: I have no stock on day i, dp[i][0] max of the below
 * - I sold it today
 * : dp[i-1][1] + prices[i]
 * - I am carry forwarding, doing nothing
 * : dp[i-1][0]
 */
public class Day29 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        if (len == 2 && prices[1] > prices[0]) {
            return prices[1] - prices[0];
        }
        if (len == 2 && prices[0] > prices[1]) {
            return 0;
        }

        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);

        for (int i = 2; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[len - 1][0];
    }
}
