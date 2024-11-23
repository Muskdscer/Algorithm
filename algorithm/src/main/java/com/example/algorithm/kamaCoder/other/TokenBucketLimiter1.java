package com.example.algorithm.kamaCoder.other;

public class TokenBucketLimiter1 {
    private long preTime = System.currentTimeMillis();
    private int putRate;
    private int capacity;
    private int bucket;
    public TokenBucketLimiter1(int putRate, int capacity) {
        this.putRate = putRate;
        this.capacity = capacity;
    }
    public boolean limit() {
        long now = System.currentTimeMillis();

        //先放入令牌，再获取令牌
        bucket = Math.min(capacity, bucket + (int) ((now - preTime) / 1000) * putRate);
        preTime = now;

        if (bucket == 0) {
            return false;
        }

        bucket--;
        return true;
    }
}
