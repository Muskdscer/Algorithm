package com.example.algorithm.kamaCoder.trace;

import java.util.*;
import java.lang.*;
import java.io.*;

public class LetterCombinations {
    static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            res = letter(s);
        }
    }

    private static List<String> letter(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }

        String[] numString = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numString, 0);
        return res;
    }

    static StringBuilder sb = new StringBuilder();
    private static void backTracking(String digits, String[] numString, int num) {
        if (num == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            //递归，处理下一层
            backTracking(digits, numString, num + 1);
            //剔除末尾的继续尝试
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
