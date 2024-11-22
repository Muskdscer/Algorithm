package com.example.algorithm.kamaCoder.hash;
import java.lang.*;
import java.util.*;
import java.io.*;


public class IsHappy {
    public static void main(String[] args) {
        boolean isFlag = isHappy(19);
        System.out.println("是否是快乐数：" + isFlag);
    }

    private static boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private static int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
