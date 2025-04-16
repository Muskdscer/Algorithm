package com.example.algorithm2025.leetCode.backTrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        //初始对应所有数字，为了直接对应2-9，新增了两个无效字符串“”
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //迭代处理
        backTracking(digits, numString, 0);
        return list;
    }

    StringBuilder temp = new StringBuilder();
    //digits为“23”
    private void backTracking(String digits, String[] numString, int num) {
        if (num == digits.length()) {
            list.add(temp.toString());
            return;
        }
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            //递归，处理下一层
            backTracking(digits, numString, num + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
