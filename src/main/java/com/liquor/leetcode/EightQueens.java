package com.liquor.leetcode;

/**
 * 八皇后问题
 * error
 */
public class EightQueens {

    static int[][] arr = new int[8][8];


    public static void main(String[] args) {

        putQueens(0);
        System.out.println("success");
    }

    static void putQueens(int row) {
        if (row == arr.length) {
            return;
        }
        final int colLen = arr[row].length;
        for (int col = 0; col < colLen; col++) {
            if (!valid(row, col)) {
                continue;
            }
            //放置皇后
            arr[row][col] = 1;
            putQueens(row + 1);
            arr[row][col] = 0;
        }
    }

    static boolean valid(int row, int col) {

        final int length = arr.length;

        //看看同一列有没有不合法的
        for (int j = 0; j < length; j++) {
            if (arr[row][j] == 1) {
                return false;
            }
        }

        //检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < length; i--, j++) {
            if (arr[i][j] == 1) {
                return false;
            }
        }

        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
