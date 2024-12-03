package com.example.algorithm.kamaCoder.hot100;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int left = 0, right = 0; right < chars.length; right++) {
            char ch = chars[right];
            if (set.contains(ch)) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
