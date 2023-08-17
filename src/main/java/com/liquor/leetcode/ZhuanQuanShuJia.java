package com.liquor.leetcode;


import java.util.ArrayList;

/**
 * 找出转圈游戏输家
 * <p>
 * https://leetcode.cn/problems/find-the-losers-of-the-circular-game/solutions/2387382/zhao-chu-zhuan-quan-you-xi-shu-jia-by-le-rfiq/
 */
public class ZhuanQuanShuJia {

    public static void main(String[] args) {
        var n = 4;
        var k = 4;

        for (int i : find(n, k)) {
            System.out.println(i);
        }

    }

    static int[] find(int n, int k) {
        var arr = new int[n];

        // 接到球的玩家索引
        var p = 0;
        // 从第一个人开始
        arr[p] = 1;

        // 传球次数，从1开始
        var cnt = 1;

        // 是否结束游戏
        var end = false;

        while (!end) {
            var next = p + cnt * k;
            cnt++;
            // 到了尾部，需要转圈从头开始
            if (next > n - 1) {
                p = next % n;
            } else {
                p = next;
            }
            arr[p] = arr[p] + 1;
            if (arr[p] == 2) {
                end = true;
            }
        }

        var list = new ArrayList<Integer>(n);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                list.add(i + 1);
            }
        }
        var result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;

    }
}
