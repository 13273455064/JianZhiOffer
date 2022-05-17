package com.liquor.jianzhioffer.no31to40;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * <p>
 * 首先必须理解啥是质因子
 * 质数(素数)： 在自然数中，除了 1 和他本身  ，没有其他的因子  ，例如   3、5、7、11，相反的叫做合数
 * 质因数 : 就是一个数的因数，并且因数为质数，  例如： 12=2×2×3、16=2×2×2×2
 *
 * @author zzc on 19.12.25
 */
public class No35 {

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        //对于1-6，都是丑数，直接返回
        if (index < 7) {
            return index;
        }

        int[] result = new int[index];
        result[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int num = 0;
        int tmp;
        //下标从0开始，而我们要的是第index个丑数，所以要-1
        while (num < index - 1) {
            //从三个队列里面选一个最小的值
            tmp = min(result[i2] * 2, min(result[i3] * 3, result[i5] * 5));
            //让三个队列中包含最小数的指针前移
            //并行的if判断而不是if else ,是因为有可能出现两个队列都匹配了最小数
            if (result[i2] * 2 == tmp) {
                i2++;
            }
            if (result[i3] * 3 == tmp) {
                i3++;
            }
            if (result[i5] * 5 == tmp) {
                i5++;
            }
            result[++num] = tmp;

        }

        //返回丑数数组的最后一个
        return result[index - 1];
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    /**
     * 最直观的解法，从0到index遍历每一个数，判断这个数字是不是丑数，但是时间复杂度比较大，因为每个数字都要经过三个循环
     */
    public int GetUglyNumber_Solution1(int index) {
        if (index <= 0) {
            return 0;
        }
        if (index == 1) {
            return index;
        }
        int n = 0;
        int cs = 0;
        while (n <= index) {
            if (isChoushu(n)) {
                cs = n;
                n++;
            }
            n++;
        }
        return cs;
    }

    private boolean isChoushu(int n) {
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }
}
