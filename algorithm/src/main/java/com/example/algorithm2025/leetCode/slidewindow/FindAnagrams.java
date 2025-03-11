package com.example.algorithm2025.leetCode.slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    private static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();  //  arraylist是有序的，有索引的
        int[] sCount = new int[26];  // 整数，记录26个小写字母的索引，a对应索引0，b对应索引1..... 每个索引对应的值，为该字母出现的次数，初始次数都是0；
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) { // 按照p字符数组的长度去遍历
            sCount[s.charAt(i) - 'a']++; // s.chartAt(i)得到此处的字母，-"a"，得到该字母的索引，++表示统计该字母的出现次数。
            pCount[p.charAt(i) - 'a']++;
        }
        //判断放置处是否有异位词。若相等，则表明s的前几位就是p的异位词。起始索引即为0.
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            sCount[s.charAt(i) - 'a']--; // 减去滑动窗口的第0位，即，窗口变为1，2
            sCount[s.charAt(i + pLen) - 'a']++; // 加上窗口的第plen位(第3位)，即，窗口变为1，2，3
            // 完成了一次滑动窗口
            // 若相等，存在异位词，起始索引为i+1
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
