package com.example.algorithm2025.leetcode01.slidewindow;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "ababecbae";
        int result = lengthOfLongestSubstring(str);
        System.out.println("无重复最长子串长度是： " + result);
    }

    public static int lengthOfLongestSubstring(String str) {
        char[] chars = str.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int result = 0;
        for (int left = 0, right = 0; right < chars.length; right++) {
            char c = chars[right];
            while (set.contains(c)) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
