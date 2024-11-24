package com.example.algorithm.kamaCoder.codeTop;

public class LeakyBucketLimiter {
    private long preTime = System.currentTimeMillis();
    private int leakRate;
    private int capacity;
    private int water;

    public LeakyBucketLimiter(int leakRate, int capacity) {
        this.leakRate = leakRate;
        this.capacity = capacity;
    }

    public boolean limit() {
        long now = System.currentTimeMillis();

        water = Math.min(0, water - (int)((now - preTime) / 1000) * leakRate);
        preTime = now;
        if (water + 1 <= capacity) {
            water++;
            return true;
        }
        return false;
    }
}
