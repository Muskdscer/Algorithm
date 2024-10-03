package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return result;
        }
        backTrack(s,0,0);
        return result;
    }

    /**
     *
     * @param s
     * @param startIndex  搜索起始位置
     * @param pointNum    添加逗点数量
     */
    private void backTrack(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            if (isValid(s,startIndex,s.length() - 1)) {
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s,startIndex,i)) {
                s = s.substring(startIndex,i + 1) + "." + s.substring(i + 1);
                pointNum++;
                backTrack(s,i + 2,pointNum);
                pointNum--;
                s = s.substring(0,i+1) + s.substring(i +2);
            } else {
                break;
            }
        }
    }

    /**
     * 判断左闭右闭区间是否合法
     * @param s
     * @param start
     * @param end
     * @return
     */
    private Boolean isValid(String s, int start, int end) {
        if (end > start) {
            return false;
        }
        if (s.charAt(start) == '0' && end != start) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + s.charAt(i) - '0';
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}
