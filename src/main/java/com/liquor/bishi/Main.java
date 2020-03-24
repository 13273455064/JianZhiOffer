package com.liquor.bishi;

import java.util.Scanner;

public class Main {

    /**
     * 两个字符串，字符只能是T和A,可以直接改，也可以交换任意两个字符的位置，
     * 输出最少的操作次数
     *
     * 例如，输入  ATTTAA
     *           TTAATT
     *
     *      输出  3
     *
     * 1.首先修改第一个位置的核酸（从A修改为T）
     * 2.交换3和5位置的核酸
     * 3.交换4和6位置的核酸
     *
     *
     * 竟然ac了18%
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println("s1=="+s1);
        System.out.println("s2=="+s2);

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i]!=arr2[i]){
                count++;
            }
        }
        if (count==0){
            System.out.println(count);
        }
        if (count%2==0){
            System.out.println(count / 2);
        }else{
            System.out.println(count/2+1);
        }

    }



}
