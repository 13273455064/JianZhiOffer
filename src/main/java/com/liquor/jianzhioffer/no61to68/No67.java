package com.liquor.jianzhioffer.no61to68;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的 数位 之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 注意是数位之和而不是数字之和，这让本来就难的题目更是雪上加霜
 * 直觉上应该是跟矩阵中的路径那个题差不多的，都是要用到回溯法，一样是要维护一个布尔的矩阵，因为机器人的运动范围同样不可以重复计算
 * 还是要用到递归，从第一个节点开始，向上下左右四个方向探索，最后把数加起来
 * @author zzc on 2020.2.5
 */
public class No67 {

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold==0){
            return 1;
        }
        //我还是比较喜欢这种二维数组的表示形式
        boolean[][] visit = new boolean[rows][cols];

        return movingCountCore(threshold,rows,cols,0,0,visit);

    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visit) {
        if (row<0 || col<0 || row>=rows || col>=cols || visit[row][col] || sum(row)+sum(col)>threshold){
            return 0;
        }
        visit[row][col] = true;
        //这里加一是因为还要把  0,0  这个位置算上
        return 1 + movingCountCore(threshold,rows,cols,row+1,col,visit)
                + movingCountCore(threshold,rows,cols,row-1,col,visit)
                + movingCountCore(threshold, rows, cols, row, col+1, visit)
                + movingCountCore(threshold, rows, cols, row, col-1, visit);
    }

    /**
     * 计算一个数的数位之和的算法
     */
    private int sum(int num) {
        int count = 0;
        while (num!=0){
            count += num % 10;
            num  /= 10;
        }
        return count;
    }
}
