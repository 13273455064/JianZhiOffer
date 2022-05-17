package com.liquor.jianzhioffer.no1to10;

public class No2 {

    /**
     * 请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，则输出“We%20are%20happy.”。
     */
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("We are happy");
        System.out.println(str);
        System.out.println(trans(str));
    }

    /**
     *
     */
    private static String trans(StringBuffer str) {
        if (str == null) {
            return "";
        }
        int oldlength = str.length();
        for (int i = 0; i < oldlength; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                str.append(" ");
                str.append(" ");
            }
        }


        int newLength = str.length();

        //原字符串上的指针
        int p1 = oldlength - 1;
        //新字符串的指针
        int p2 = newLength - 1;
        //从后面向前遍历
        while (p1 >= 0 && p2 > p1) {
            char a = str.charAt(p1--);
            if (a == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, a);
            }
        }
        return str.toString();
    }
}
