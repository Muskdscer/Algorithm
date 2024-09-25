package com.example.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口
        char[] ss = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = ss[right];
            while (set.contains(c)) {
                set.remove(ss[left++]);
            }
            set.add(c);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
