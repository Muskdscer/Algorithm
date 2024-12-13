package com.example.algorithm.kamaCoder.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeparatePalindromicSubstrs {
    static List<List<String>> res = new ArrayList<>();
    static LinkedList<String> path = new LinkedList<>();
    public static void main(String[] args) {
        String s = "aab";
        backTrack(s, 0, new StringBuilder());
    }

    private static void backTrack(String s, int start, StringBuilder sb) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isPalindromic(sb)) {
                path.add(sb.toString());
                backTrack(s, i+1, new StringBuilder());
                path.removeLast();
            }
        }
    }

    private static boolean isPalindromic(StringBuilder sb) {
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
