package com.example.algorithm2025.leetCode;

import java.util.Arrays;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int result = lengthOfLongestSubstring(str);
    }

    private static int lengthOfLongestSubstring(String str) {
        char[] chars = str.toCharArray();
        //去重
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (int left = 0, right = 0; right < str.length(); right++) {
            char ch = chars[right];
            while (set.contains(ch)) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
