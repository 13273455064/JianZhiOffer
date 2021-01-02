package com.liquor.jianzhioffer.no41to50;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 *
 * 这不就是等差数列求和嘛,这特码也太简单了，不是来捣乱的吗
 * @author zzc on 2020.1.14
 */
public class No49 {

    public int Sum_Solution(int n) {
        if (n<0){
            return -1;
        }
        if (n<=1){
            return n;
        }
        return ((1+n)*n)/2;
    }
}
