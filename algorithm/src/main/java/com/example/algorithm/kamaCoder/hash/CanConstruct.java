package com.example.algorithm.kamaCoder.hash;

import java.lang.*;
import java.util.*;
import java.io.*;

public class CanConstruct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(" ");
            String strA = s[0];
            String strB = s[1];
            boolean flag = canConstruct(strA, strB);
            System.out.println("是否可以赎回：" + flag);
        }
    }

    private static boolean canConstruct(String strA, String strB) {
        int[] res = new int[26];
        for (int i = 0; i < strA.length(); i++) {
            res[strA.charAt(i) - 'a']++;
        }
        for (int i = 0; i < strB.length(); i++) {
            res[strB.charAt(i) - 'a']--;
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
