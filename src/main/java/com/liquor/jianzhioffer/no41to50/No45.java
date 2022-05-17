package com.liquor.jianzhioffer.no41to50;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * <p>
 * 给出我的思路，借助String类的sub方法，进行字符串的截取，把原字符串截取一个字符串数组，包含两个子字符串
 * 第一个子字符串是0到 n,第二个是 n到length,然后再调换顺序
 * <p>
 * 不过需要注意的是，substring这个方法，从beginIndex开始取，到endIndex结束，从0开始数，其中不包括endIndex位置的字符！
 *
 * @author zzc on 2020.1.11
 */
public class No45 {
    public static String LeftRotateString(String str, int n) {
        if (n > str.length()) {
            return "";
        }
        String arr1 = str.substring(0, n);
        String arr2 = str.substring(n);
        return arr2 + arr1;
    }

    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcdefg", 2));
    }
}
