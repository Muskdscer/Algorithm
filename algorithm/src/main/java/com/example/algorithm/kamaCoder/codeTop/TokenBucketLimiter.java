package com.example.algorithm.kamaCoder.codeTop;

public class TokenBucketLimiter {
    private long pre = System.currentTimeMillis();
    private int rate;
    private int capacity;
    private int count;

    public TokenBucketLimiter(int putRate, int capacity) {
        this.rate = putRate;
        this.capacity = capacity;
    }

    public boolean limit() {
        long now = System.currentTimeMillis();
        count = Math.min(capacity, count + (int) ((now - pre) / 1000) * rate);
        pre = now;

        if (count == 0) {
            return false;
        }

        count--;
        return true;
    }
}
