package com.example.algorithm.greedy;

import java.util.Arrays;

public class FindContentChildren {
    //优先考虑胃口
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int start = s.length - 1;
        //遍历胃口
        for (int i = g.length - 1; i >= 0; i--) {
            if (start >= 0 && g[i] <= s[start]) {
                start--;
                count++;
            }
        }
        return count;
    }

}
