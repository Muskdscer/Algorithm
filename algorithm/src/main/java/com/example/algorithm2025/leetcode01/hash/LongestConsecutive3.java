package com.example.algorithm2025.leetcode01.hash;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive3 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : set) {
            set.add(i);
        }

        int longseq = 0;
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int cur = i;
                int sum = 1;
                while (set.contains(cur +1)) {
                    cur = cur + 1;
                    sum = sum + 1;
                }
                longseq = Math.max(longseq, sum);
            }
        }
        return longseq;
    }
}
