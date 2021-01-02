package com.liquor.jianzhioffer.no61to68;

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
        /**
         * 当length<=3的时候，我们直接返回了结果。如果整个绳子的长度为3，我们必须把绳子剪开，因为题目要求m>1，其中一段为2，另一段为1，这样结果就是2。
         * 当length>=4的时候，我们可以把绳子剪成两段，其中一段为3另一段为１，这样长度为3的那一段的最大值就是3而不是2，因为这一段我们不需要再剪了。
         * 当然长度为4的最大值是2和2的组合，我们已经存储了2的长度。
         */
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

    /**
     * 贪心算法
     */
    public int cutRope2(int target) {
        if (target <= 1)
            return 0;
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;
        //尽可能多的取3
        int count3 = target /3;
        //如果余1，需要退一个
        if (target % 3 ==1){
            count3--;
        }
        int count2 = (target - count3*3)/2;
        return (int) (Math.pow(3, count3) * Math.pow(2, count2));
    }
}
