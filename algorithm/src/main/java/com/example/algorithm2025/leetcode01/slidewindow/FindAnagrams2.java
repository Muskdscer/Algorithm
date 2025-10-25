package com.example.algorithm2025.leetcode01.slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams2 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int[] scount = new int[26];
        int[] pcount = new int[26];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            scount[s.charAt(i) - 'a']++;
            pcount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(scount, pcount)) {
            res.add(0);
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            scount[s.charAt(i) - 'a']--;
            scount[s.charAt(i + p.length()) - 'a']++;
            if (Arrays.equals(scount, pcount)) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
