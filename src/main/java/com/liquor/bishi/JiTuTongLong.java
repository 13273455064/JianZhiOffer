package com.liquor.bishi;

import java.util.Scanner;

public class JiTuTongLong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getIndex(n));
    }

    public static int getIndex(int n){
        if (n<5){
            return 1;
        }
        return getIndex(n-1)+getIndex(n-1);
    }
}
