package com.liquor.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 * https://leetcode.cn/problems/combinations/
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 */
public class Combinations {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        LinkedList<Integer> track = new LinkedList<>();

        backtrack(n, k, track, 1);
        System.out.println(result);
    }

    static void backtrack(int n, int k, LinkedList<Integer> track, int start) {
        // 结束条件，数组中的元素数等于 k
        if (track.size() == k) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            // 做选择
            track.addLast(i);
            // 进入下一层递归
            backtrack(n, k, track, i + 1);
            // 撤消选择
            track.removeLast();
        }

    }


}
