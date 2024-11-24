package com.example.algorithm.kamaCoder.codeTop;

public class CountLimiter {
    private int max;
    private long firstTime = System.currentTimeMillis();
    private long timeWindow;
    int count;

    public CountLimiter(int max, int timeWindow) {
        this.max = max;
        this.timeWindow = timeWindow;
    }

    public boolean limit() {
        long now = System.currentTimeMillis();
        if (now - firstTime > timeWindow) {
            //下个窗口
            count = 1;
            firstTime = now;
            return true;
        }

        //还在当前窗口
        if (count + 1 < max) {
            count++;
            return true;
        }

        return false;

    }
}
