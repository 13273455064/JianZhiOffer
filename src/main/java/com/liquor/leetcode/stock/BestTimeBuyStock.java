package com.liquor.leetcode.stock;


/**
 * 买卖股票的最佳时间
 * <p>
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
 */
public class BestTimeBuyStock {

    public static void main(String[] args) {

        var prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];

        // 第一天不持有，利润为0
        dp[0][0] = 0;
        // 第一天买入，也就是持有，利润为 - prices[0]
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 只能交易一次，如果昨天选择持有，今天
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
