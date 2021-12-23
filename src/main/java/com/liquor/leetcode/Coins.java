package com.liquor.leetcode;

import java.util.Arrays;

/**
 * 凑硬币
 */
public class Coins {

    static int[] mono;

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int count = 11;
        mono = new int[count + 1];
        Arrays.fill(mono, -2);
        System.out.println(dp(coins, count));
    }

    private static int dp(int[] coins, int count) {
        if (count == 0) {
            return 0;
        }
        if (count < 0) {
            return -1;
        }
        if (mono[count] != -2) {
            return mono[count];
        }
        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            final int sub = dp(coins, count - coin);
            if (sub == -1) {
                continue;
            }
            //子问题的最优解加一，就是本问题的最优解
            min = Math.min(min, sub + 1);
        }
        mono[count] = min == Integer.MAX_VALUE ? -1 : min;
        return mono[count];
    }

}
