package com.example.algorithm.kamaCoder.other;

public class LeakyBucketLimiter1 {
    private long preTime = System.currentTimeMillis();
    private int leakRate;
    private int capacity;
    private int water;
    public LeakyBucketLimiter1(int leakRate, int capacity)
    {
        this.leakRate = leakRate;
        this.capacity = capacity;
    }
    public boolean limit() {
        long now = System.currentTimeMillis();

        //先漏水，计算剩余水量
        water = Math.max(0, water - (int)((now - preTime) / 1000 * leakRate));
        preTime = now;

        //桶未满
        if (water + 1 <= capacity) {
            water++;
            return true;
        }
        return false;
    }
}
