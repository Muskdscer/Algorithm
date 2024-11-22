package com.example.algorithm.kamaCoder.str;

import java.util.*;
import java.lang.*;
import java.io.*;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        Set<Character> set = new TreeSet<>();
        for (int left = 0, right = 0; right < chars.length; right++) {
            while (set.contains(chars[right])) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
