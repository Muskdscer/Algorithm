package com.example.algorithm2025.leetCode.slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams2 {
    public static void main(String[] args) {
        String s= "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams1(s, p);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    private static List<Integer> findAnagrams1(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            result.add(0);
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + p.length()) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
