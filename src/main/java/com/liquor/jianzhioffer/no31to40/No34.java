package com.liquor.jianzhioffer.no31to40;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * <p>
 * 先把数组中的数字进行排序，
 *
 * @author zzc on 19.12.21
 */
public class No34 {

    public String PrintMinNumber(int[] numbers) {
        if (numbers.length <= 0) {
            return "";
        }
        List<String> list = new ArrayList<>();
        for (int n : numbers) {
            list.add(String.valueOf(n));
        }
        list.sort((o1, o2) -> {
            String a = o1 + o2;
            String b = o2 + o1;
            return a.compareTo(b);
        });
        StringBuilder buffer = new StringBuilder();
        for (String s : list) {
            buffer.append(s);
        }
        return buffer.toString();
    }
}
