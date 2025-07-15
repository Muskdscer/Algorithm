package com.example.algorithm2025.leetcode01.backTrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        combineHelper(digits, 0);
        return list;
    }

    StringBuilder sb = new StringBuilder();
    private void combineHelper(String digits, int num) {
        if (num == digits.length()) {
            list.add(sb.toString());
            return;
        }

        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            combineHelper(digits, num + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
