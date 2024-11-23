package com.example.algorithm.kamaCoder.other;

import java.util.LinkedList;

public class SlidingWindowLimiter1 {
    private long intervalWindow;
    private int max;
    private LinkedList<Long> list = new LinkedList<>();
    public SlidingWindowLimiter1(int intervalWindow, int max) {
        this.intervalWindow = intervalWindow;
        this.max = max;
    }

    public boolean limit() {
        long now = System.currentTimeMillis();

        //队列未满  说明当前窗口还可以接受请求
        if (list.size() < max) {
            list.addLast(now);
            return true;
        }

        //队列已满
        Long first = list.getFirst();
        if (now - first <= intervalWindow) {
            //说明新请求和队列中的请求还处于一个窗口内，出发了限流
            return false;
        }

        //说明新请求和队列中的请求不在通过窗口内
        list.removeFirst();
        list.addLast(now);
        return true;
    }
}

