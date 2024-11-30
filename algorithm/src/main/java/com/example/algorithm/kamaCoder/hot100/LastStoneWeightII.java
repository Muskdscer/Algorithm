package com.example.algorithm.kamaCoder.hot100;

public class LastStoneWeightII {

    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        int result = getResult(stones);
    }

    private static int getResult(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - 2 * dp[target];
    }
}
