package com.liquor.offer.no41to50;

/**
 * 不用加减乘除做加法; 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 不让用四则运算，这不是疯狂暗示我用位运算昂
 *
 * 二进制相加，1+0=1，1+1=0,0+0=0,
 * 不考虑进位时，异或可以实现二进制相加
 * 考虑进位时，与运算再左移一位，因为进了一位嘛
 *
 * https://www.nowcoder.com/profile/645151/codeBookDetail?submissionId=1512236
 *
 * @author zzc on 2020.1.14
 */
public class No50 {

    public int Add(int num1,int num2) {

        while (num2!=0){
            int noJinWei = num1^num2;
            int haveJinwei = (num1&num2)<<1;
            //一直到没进位为止
            num1 = noJinWei;
            num2 = haveJinwei;
        }
        return num1;
    }
}
