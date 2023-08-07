package com.liquor.leetcode.dp;

import java.util.Arrays;

/**
 * 凑硬币问题
 * https://leetcode.cn/problems/coin-change/
 */
public class CoinChange {

    static int[] table = null;

    public static void main(String[] args) {
        var coins = new int[]{1,2,5};
        var amount = 11;
        table = new int[amount + 1];
        Arrays.fill(table, -888);
        System.out.println(dp(coins, amount));
    }



    static int dp(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        if (table[amount] != -888) {
            return table[amount];
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 子问题的最优解
            int subMin = dp(coins, amount - coin);
            if (subMin == -1) {
                continue;
            }
            // 子问题的最优解加一，就是最终需要最少的硬币，加一是因为要加上当前的硬币
            result = Math.min(result, subMin + 1);
        }
        result = result == Integer.MAX_VALUE ? -1 : result;
        table[amount] = result;
        return result;
    }
}
