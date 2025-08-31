package com.example.algorithm2025.leetcode01.hash;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive1 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestSeq = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curSeq = 1;
                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    curSeq += 1;
                }
                longestSeq = Math.max(longestSeq, curSeq);
            }
        }
        return longestSeq;
    }
}
