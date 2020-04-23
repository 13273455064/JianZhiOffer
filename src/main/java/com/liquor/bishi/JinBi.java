package com.liquor.bishi;

import java.math.BigDecimal;
import java.util.Scanner;

public class JinBi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double a = n;
        if (a<990){
            BigDecimal one = new BigDecimal(1);

            BigDecimal right = new BigDecimal(1);
            for (double i=1;i<=a;i++){
                right = right.multiply(BigDecimal.valueOf((990 - i + 1) / (1000 - i + 1)));
            }
            System.out.println(one.subtract(right).setScale(6,BigDecimal.ROUND_HALF_UP));
        }else if (a>=990 && a<1001){
            double result = 1.0;
            System.out.println(result);
        }
    }
}
