package com.liquor.leetcode.stock;

/**
 * 买卖股票的最佳时间
 * <p>
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * <p>
 * 交易次数无限制
 */
public class BestTimeBuyStockII {

    public static void main(String[] args) {


        var prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    static int maxProfit(int[] prices) {

        var dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
