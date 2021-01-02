package com.liquor.jianzhioffer.no51to60;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入一个字符串,包括数字字母符号,可以为空;如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 *  +2147483647   1a33
 * 输出
 *  2147483647    0
 *
 *  这个题重点不在解题的思路，而在能否把各种边界条件考虑全面，总结一下学到的东西
 *
 *  int类型转char类型，将数字加一个‘0’，并强制类型转换为char即可。
 *  char类型装int类型，将字符减一个‘0’即可。
 *  字符串转int,一定要注意是否超过int的范围
 *  char的操作，要用单引号''
 *
 * @author zzc on 2020.1.15
 */
public class No51 {

    public static int StrToInt(String str) {
        if (str==null || str.length()==0){
            return 0;
        }
        //数字开始的位置，是0或者1
        int start = 0;
        //是否是负数
        boolean minus = false;
        char[] chars = str.toCharArray();
        //使用long，防止溢出
        long result = 0;
        if (chars[0]=='+'){
            start = 1;
        }else if (chars[0]=='-'){
            start = 1;
            minus = true;
        }
        for (int i=start;i<chars.length;i++){
            if (chars[i]>='0' && chars[i]<='9'){
                result = result * 10 + (chars[i] - '0');
                //int 的范围是  2^-32 到  2^32-1
                if (minus && -result<Integer.MIN_VALUE){
                    //判断是否超过int型下边界
                    return 0;
                }else if (!minus && result>Integer.MAX_VALUE){
                    //判断是否超过int型下边界
                    return 0;
                }
            }else{
                //说明不是数字，直接返回
                return 0;
            }
        }
        if (minus){
            result = -1 * result;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("-2147483649"));
    }
}
