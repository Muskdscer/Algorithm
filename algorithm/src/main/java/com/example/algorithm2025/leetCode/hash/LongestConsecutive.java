package com.example.algorithm2025.leetCode.hash;

import java.util.HashSet;

public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int result = longestConsecutive(nums);
        System.out.println("最长的序列长度为: " + result);
    }

    private static int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
