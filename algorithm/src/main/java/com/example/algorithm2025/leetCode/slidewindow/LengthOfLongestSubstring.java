package com.example.algorithm2025.leetCode.slidewindow;

import java.util.Arrays;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "ababecbae";
        int result = lengthOfLongestSubstring(str);
        System.out.println("最大长度： " + result);
    }

    private static int lengthOfLongestSubstring(String str) {
        char[] chars = str.toCharArray();
        //去重
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (int left = 0, right = 0; right < str.length(); right++) {
            char ch = chars[right];
            //set只要还包含ch就一直while循环set从左边删除set里面元素  left++
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
