package com.example.algorithm2025.leetcode01.slidewindow;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = 0;
        Set<Character> set = new HashSet<>();
        for (int left = 0,right = 0; right < chars.length; right++) {
            while (set.contains(chars[right])) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);
            length = Math.max(length, right - left + 1);
        }
        return length;
    }
}
