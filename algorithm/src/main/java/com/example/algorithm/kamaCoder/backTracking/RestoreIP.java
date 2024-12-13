package com.example.algorithm.kamaCoder.backTracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {

    static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        String s = "25525511135";
        res = restoreIpAddresses(s, 0, 0);
    }

    private static List<String> restoreIpAddresses(String s, int start, int pointNum) {
        if (s.length() > 12) {
            return res;
        }
        backTrack(s, start, pointNum);
        return res;
    }

    private static void backTrack(String s, int start, int pointNum) {
        if (pointNum == 3) {
            if (isOk(s, start, s.length() - 1)) {
                res.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isOk(s, start, i)) {
                s = s.substring(start, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                backTrack(s, i + 2, pointNum);
                pointNum--;
                s = s.substring(start, i + 1) + s.substring(i + 2);
            } else {
                break;
            }
        }
    }

    private static boolean isOk(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }

        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + s.charAt(i) - '0';
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
