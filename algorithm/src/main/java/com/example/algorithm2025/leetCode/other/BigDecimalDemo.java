package com.example.algorithm2025.leetCode.other;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        double totalAmount = 0.09;
        double freeAmount = 0.02;
        BigDecimal tradeAmount = new BigDecimal(String.valueOf(totalAmount)).subtract(new BigDecimal(String.valueOf(freeAmount)));
        System.out.println(tradeAmount);
    }
}
