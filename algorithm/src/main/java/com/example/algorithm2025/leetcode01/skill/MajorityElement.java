package com.example.algorithm2025.leetcode01.skill;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int winner = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (winner == nums[i]) {
                count++;
            } else if (count == 0) {
                winner = nums[i];
                count++;
            } else {
                count--;
            }
        }
        return winner;
    }
}
