package com.liquor.jianzhioffer.no51to60;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * @author zzc on 2020.1.16
 */
public class No54 {

    public static boolean match(char[] str, char[] pattern) {

        //字符串和模式都是空，返回true
        if(str.length==0 && pattern.length==0){
            return true;
        }
        //字符串非空，模式空，返回false,因为这样就无法匹配了
        if (str.length!=0 && pattern.length==0){
            return false;
        }
        //字符串空，模式非空，是有可能匹配成功的，因为  * 可以包含0次
        return matchByIndex(str,0,pattern,0);
    }

    public static boolean matchByIndex(char[] str,int strIndex,char[] pattern, int patternIndex){
        //字符串和模式都到头了，说明匹配成功，返回true
        if (strIndex==str.length && patternIndex==pattern.length){
            return true;
        }
        //字符串没到头，模式到头了,说明匹配失败
        if (strIndex!=str.length && patternIndex==pattern.length){
            return false;
        }
        //当模式的下一个字符是  * 时，(要时刻注意数组溢出)
        if (patternIndex+1<pattern.length && pattern[patternIndex+1]=='*'){
            //字符串和模式的当前字符相等  或者是模式的当前字符是 . ,说明这个 * 匹配的是一个或多个。
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                    || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchByIndex(str, strIndex, pattern, patternIndex + 2)//模式后移2，相当于  *  和它前面的字符被忽略了，例如   aaa  与 ab*aa
                        || matchByIndex(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符,例如  abcde  与  a*bcde
                        || matchByIndex(str, strIndex + 1, pattern, patternIndex);//  *  匹配了多个，再匹配str中的下一个,例如 aaa  与  a*
            }else{
                //字符串和模式的当前字符不相等，说明这个 * 匹配的是0个，应该把模式的索引+2，跳过这个 *
                return matchByIndex(str,strIndex,pattern,patternIndex+2);
            }
        }
        //当模式的下一个字符不是 * 时，直接匹配两个字符是否相等就好了
        //字符串和模式的当前字符相等  或者是模式的当前字符是 . ,开始匹配下一个
        if (strIndex != str.length ) {
            if (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.' ){
                return matchByIndex(str,strIndex+1,pattern,patternIndex+1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[] str = {};
        char[] pattern = { '.','*' };
        System.out.println(match(str, pattern));
    }
}
