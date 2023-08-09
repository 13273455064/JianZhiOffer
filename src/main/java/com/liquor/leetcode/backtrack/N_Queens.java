package com.liquor.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * N 皇后问题
 * https://leetcode.cn/problems/n-queens/
 * <p>
 * 皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class N_Queens {

    static List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        var n = 4;
        solveNQueens(n);
        System.out.println(result);
    }

    static List<List<String>> solveNQueens(int n) {
        // 先初始化棋盘
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(".".repeat(n));
            board.add(sb.toString());
        }
        backtrack(board, 0);

        return result;
    }

    /**
     * @param board 整个棋盘，用一个 String 表示每一行的结果
     * @param row   当前回溯处理的行数
     */
    static void backtrack(List<String> board, int row) {

        int n = board.size();
        // 首先确定终止条件
        if (row == n) {
            result.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            // 排除不合法的路径
            if (!isVaild(board, row, col)) {
                continue;
            }

            // 做选择
            StringBuilder sb = new StringBuilder(board.get(row));
            sb.setCharAt(col, 'Q');
            board.set(row, sb.toString());

            //进入下一层递归
            backtrack(board, row + 1);

            // 撤消选择
            sb.setCharAt(col, '.');
            board.set(row, sb.toString());

        }

    }

    static boolean isVaild(List<String> board, int row, int col) {
        int n = board.size();

        // 检验放置位置上方有没有皇后
        for (String s : board) {
            if (s.charAt(col) == 'Q') {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            if (board.get(row).charAt(i) == 'Q') {
                return false;
            }
        }

        //检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
