package com.liquor.jianzhioffer.no51to60;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 本来以为这个题很简单只需要遍历匹配就好了，可当我看到了题目描述中的  5e2, -1E-16,这啥玩意啊
 * 菜是原罪，我把脑海中仅有的数学知识掏出来，想起来  e和指数是干嘛的，  5e2  表示5个e的2次方，-1E-16表示-1 * E的-16次方，无理数E可大写可小写
 *
 * 解题思路就是从头到尾遍历，然后设置三个标志位，分表表示正负号 +/-，无理数 e/E ,小数点  .
 * 然后根据是否是数字的原则，整理几个规则
 * 1. 正负号不能连续
 * 2. 正负号应该在整数部分的前面
 * 3. 正负号最多可以出现多次，但是第二次的前一个字符必须是  e/E
 * 4. 无理数 e/E 最多出现一次
 * 5. 无理数 e/E 不能出现在最后
 * 6. 小数点最多出现一次
 * 7. 无理数 e/E 后面不能出现小数点
 * 8. 所有字符必须在 0-9 之间
 * 确定了这些规则，代码就好写了
 * 需要注意的是，很难一下把这些规则考虑到，需要多次总结、试错
 * @author  zzc on 2020.1.26
 */
public class No55 {
    public static boolean isNumeric(char[] str) {
        if (str.length==0){
            return false;
        }
        int len = str.length;
        boolean zhengFu = false;
        boolean hasE = false;
        boolean xiaoShuDian = false;
        for (int i=0;i<len;i++){
            if (str[i]=='+' || str[i]=='-'){
                if (!zhengFu && i>=1 && str[i-1]!='e' && str[i-1]!='E'){
                    //2. 正负号应该在整数部分的前面
                    //3. 正负号最多可以出现多次，但是第二次的前一个字符必须是  e/E
                    return false;
                }
                if (zhengFu && str[i-1]!='e' && str[i-1]!='E' ){
                    //1. 正负号不能连续
                    //3. 正负号最多可以出现多次，但是第二次的前一个字符必须是  e/E
                    return false;
                }
                zhengFu = true;
            }else if (str[i]=='e' || str[i]=='E'){
                if (i==len-1){
                    //5. 无理数 e/E 不能出现在最后
                    return false;
                }
                if (hasE){
                    //4. 无理数 e/E 最多出现一次
                    return false;
                }
                hasE = true;
            }else if (str[i]=='.'){
                if (hasE || xiaoShuDian){
                    //6. 小数点最多出现一次
                    //7. 无理数 e/E 后面不能出现小数点
                    return false;
                }
                xiaoShuDian = true;
            }else if (str[i] < '0' || str[i] > '9'){
                //8. 所有字符必须在 0-9 之间
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isNumeric("123.45e+6".toCharArray()));
    }
}
