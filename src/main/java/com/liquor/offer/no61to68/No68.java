package com.liquor.offer.no61to68;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 理解动态规划： https://www.zhihu.com/question/23995189
 * 理解本题  ： https://blog.csdn.net/upupday19/article/details/79315885
 * 总算是理解了动态规划，哈哈哈
 * 这题可以使用动态规划和贪心两种解法
 *
 *
 * 动态规划的核心就是
 * 1.求一个问题的最优解（要求最优解）
 * 2.整体问题的最优解依赖各子问题的最优解（最优子问题）
 * 3.小问题之间还有相互重叠的更小的子问题
 * 4.为了避免小问题的重复求解，采用从上往下分析和从下往上求解的方法求解问题（未来与过去无关）
 *
 *
 *  贪心算法的核心就是
 *  我不管，我就要先把大的占下来，尽可能的让后面的结果小
 * @author zzc on 2020.2.
 */
public class No68 {
    /**
     * 动态规划算法
     */
    public int cutRope(int target) {
        if (target <= 1)
            return 0;
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;
        int[] result = new int[target+1];
        //没有说必须要剪，当长度为2/3时，可以不剪，这样乘积最大
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        for (int i = 4; i <= target; i++) {
            int max = 0;
            for (int j=1;j<= i/2;j++){
                int i1 = result[j] * result[i - j];
                if (i1 > max){
                    max = i1;
                }
            }
            result[i] = max;
        }
        return result[target];
    }
}
