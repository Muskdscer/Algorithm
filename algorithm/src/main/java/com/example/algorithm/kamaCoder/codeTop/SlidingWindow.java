package com.example.algorithm.kamaCoder.codeTop;

import java.util.LinkedList;

public class SlidingWindow {
    private int max;
    private long timeWindow;
    private LinkedList<Long> list = new LinkedList<>();

    public SlidingWindow(int intervalWindow, int max) {
        this.timeWindow = intervalWindow;
        this.max = max;
    }

    public boolean limit() {
        long now = System.currentTimeMillis();
        //队列未满
        if (list.size() < max) {
            list.add(now);
            return true;
        }

        //队列已满
        Long first = list.getFirst();
        if (now - first < timeWindow) {
            //还在一个窗口内
            return false;
        }

        //说明新请求和队列中的请求不在通过窗口内
        list.removeFirst();
        list.addLast(now);
        return true;
    }
}
