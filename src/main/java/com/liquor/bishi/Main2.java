package com.liquor.bishi;

import java.util.Scanner;

public class Main2 {

    /**
     * A、B两人抽奖，n个中奖票，m个不中奖票
     * 轮流抽，抽到中奖就结束，
     * B抽完之后会再抽一张并丢弃，（丢弃的这个如果中奖了不算）
     * 到最后谁都没抽到算B胜利
     * A先抽，输出A的胜率，保留四位小数，
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(select(n, m));
    }

    public static double select(int n, int m){
        double result = 0;

        if (n==m){
            for (int i = 0; i < n + m-1; i++) {
                if (i==0){
                    result = 0.5;
                }
                result +=n/n+m-1;
            }
        }
        return result;
    }
}
