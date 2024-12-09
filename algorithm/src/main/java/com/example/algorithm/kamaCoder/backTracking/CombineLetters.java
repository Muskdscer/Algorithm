package com.example.algorithm.kamaCoder.backTracking;

import java.util.ArrayList;
import java.util.List;

public class CombineLetters {
    static List<String> result = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        String[] strs = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String digits = "23";
        backTrackingLetters(digits, strs, 0);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    private static void backTrackingLetters(String digits, String[] strs, int num) {
        if (num == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String str = strs[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTrackingLetters(digits, strs, num + 1);//加完变成2 进入方法运行 num == digits.length() 结束
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
