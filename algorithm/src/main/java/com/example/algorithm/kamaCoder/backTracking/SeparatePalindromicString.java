package com.example.algorithm.kamaCoder.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeparatePalindromicString {

    static List<List<String>> res = new ArrayList<>();
    static LinkedList<String> path = new LinkedList<>();
    public static void main(String[] args) {
        String s = "aab";
        backTrack(s, 0, "");
    }

    private static void backTrack(String s, int start, String str) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isRight(s, start, i)) {
                path.add(s.substring(start, i+1));
                backTrack(s, i+1, "");
                path.removeLast();
            }
        }
    }

    private static boolean isRight(String s, int start, int end) {
        for (int i = start, j = end; i >= j ; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
