package com.example.algorithm2025.leetCode.dp;

import java.util.HashSet;
import java.util.List;

public class WordBreak1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        //valid[i] : 字符串长度为i的话，valid[i]为true，表示可以拆分为一个或多个在字典中出现的单词
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i && !valid[i]; j++) {
                if (set.contains(s.substring(j, i)) && valid[j]) {
                    valid[i] = true;
                }
            }
        }
        return valid[s.length()];
    }
}
