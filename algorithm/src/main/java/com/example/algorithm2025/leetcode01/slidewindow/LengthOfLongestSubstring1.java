package com.example.algorithm2025.leetcode01.slidewindow;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring1 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int left = 0,right = 0; right < chars.length; right++) {
            while (set.contains(chars[right])) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);
            count = Math.max(count, right - left + 1);
        }
        return count;
    }
}
