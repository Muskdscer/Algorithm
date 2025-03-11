package com.example.algorithm2025.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams1 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    private static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<Integer>();
        }
        List<Integer> ans = new ArrayList<Integer>();
         int[] scount = new int[26];
         int[] pcount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            scount[s.charAt(i) - 'a']++;
            pcount[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(scount, pcount)) {
            ans.add(0);
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            scount[s.charAt(i) - 'a']--;
            scount[s.charAt(i + p.length()) - 'a']++;
            if (Arrays.equals(scount, pcount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
