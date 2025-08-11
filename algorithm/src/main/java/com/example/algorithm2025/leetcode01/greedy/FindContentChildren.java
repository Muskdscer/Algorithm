package com.example.algorithm2025.leetcode01.greedy;

import java.util.Arrays;

public class FindContentChildren {
    //优先考虑胃口 先喂饱大胃口
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int start = s.length - 1;
        //遍历胃口
        for (int index = g.length - 1; index >= 0 ; index--) {
            if (start >= 0 && g[index] <= s[start]) {
                start--;
                count++;
            }
        }
        return count;
    }
}
