package com.example.algorithm.kamaCoder.other;

public class CountLimiter1 {
    private long intervalWindow;
    private int max;
    private int count;
    private long firstReqTime = System.currentTimeMillis();
    public CountLimiter1(long intervalWindow, int max) {
        this.intervalWindow = intervalWindow;
        this.max = max;
    }
    public boolean limit() {
        long now = System.currentTimeMillis();
        if (now > firstReqTime + intervalWindow) {
            //代表进入下个窗口
            firstReqTime = now;
            count = 1;
            return true;
        }

        //还在当前时间窗口内
        if (count +1 <= max) {
            count++;
            return true;
        }
        return false;
    }
}
