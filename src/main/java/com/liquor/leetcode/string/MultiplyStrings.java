package com.liquor.leetcode.string;

/**
 * 字符串相乘
 * <p>
 * https://leetcode.cn/problems/multiply-strings/description/
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        var num1 = "999";
        var num2 = "999";
        System.out.println(multiply(num1, num2));

    }

    public static String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder curr = new StringBuilder();
            int add = 0;
            curr.append("0".repeat(Math.max(0, n - 1 - i)));
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = AddString.addString2(ans, curr.reverse().toString());
        }
        return ans;
    }

    static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        var chars1 = num1.toCharArray();
        var chars2 = num2.toCharArray();

        // 进位数字
        var res = "";

        // 中 num2 的右边向左边，挨个和 num1 的数字相乘
        for (int i = chars2.length - 1; i >= 0; i--) {
            var sb = new StringBuffer();
            var add = 0;
            // 先补后面的 0
            sb.append("0".repeat(Math.max(0, chars2.length - i - 1)));
            var s2 = chars2[i] - '0';

            for (int j = chars1.length - 1; j >= 0; j--) {
                var s1 = chars1[j] - '0';
                var multip = s1 * s2 + add;
                add = multip / 10;
                sb.append(multip % 10);
            }
            if (add > 0) {
                sb.append(add % 10);
            }
            res = AddString.addString2(res, sb.reverse().toString());
        }


        return res;
    }
}
