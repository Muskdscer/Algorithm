package com.example.algorithm2025.leetCode.slidewindow;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring1 {
    public static void main(String[] args) {
        String str = "ababecbae";
        int length = lengthOfLongestSubstring1(str);
        System.out.println("无重复最长字串长度为：" + length);
    }

    private static int lengthOfLongestSubstring1(String str) {
        int max = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        for (int left = 0, right = 0; right < str.length(); right++) {
            while (set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            }
            set.add(str.charAt(right));
            max = Math.max(max, right- left + 1);
        }
        return max;
    }
}
