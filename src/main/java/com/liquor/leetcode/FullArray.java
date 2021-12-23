package com.liquor.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 */
public class FullArray {

    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(arr,track);
        System.out.println(res);
    }

    private static void backtrack(int[] arr, LinkedList<Integer> track) {
        if (arr.length == track.size()) {
            //这里一定要 new，在撤销选择之前保存到返回值里面
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i : arr) {
            //已经选过了，就跳过
            if (track.contains(i)) {
                continue;
            }
            //做选择
            track.add(i);
            //进入下一层决策树
            backtrack(arr, track);
            //撤销选择
            track.removeLast();
        }
    }
}
