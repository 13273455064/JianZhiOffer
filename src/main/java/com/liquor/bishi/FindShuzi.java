package com.liquor.bishi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindShuzi {
    public static void main(String[] args) {
        String s = "7i8hy4jjnb2";
        //1.使用正则表达式
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(s);
        System.out.println(m.replaceAll("").trim());


        //2.使用for循环ASCII码判断,48-57之间对应的是0-9
        StringBuilder sb = new StringBuilder();
        for (char c:s.toCharArray()){
            if (c>=48 && c<=57){
                sb.append(c);
            }
        }
        System.out.println(sb.toString());

    }

}
