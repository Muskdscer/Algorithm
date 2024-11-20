package com.example.algorithm.kamaCoder;

import java.util.LinkedList;

/**
 * 滑动窗口限流
 *
 * 滑动窗口法以每一个请求为窗口结束期，向前截取intervalWindow长度，检查该范围内的请求总和，相当于会为每个请求开辟一个新窗口
 *
 * 既然要知道前intervalWindow长度内到底有多少个请求，那么就要为每个放行的请求记录发生时间。
 *
 */
public class SlidingWindowLimiter {

    /**
     * 时间间隔窗口(单位:毫秒)
     */
    private long intervalWindow;
    /**
     * 窗口内的最大请求数
     */
    private int max;

    /**
     * 限流容器
     * 队列尾部保存最新通过的请求时间
     */
    private LinkedList<Long> list = new LinkedList<>();

    public SlidingWindowLimiter(int intervalWindow, int max) {
        this.intervalWindow = intervalWindow;
        this.max = max;
    }

    //省略 get set 方法
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

    /**
     * 也可以使用Redis的List或Zset实现吗，大致步骤和以上demo类似
     *
     * 这里多说一句，限流中的滑动窗口法和TCP的滑动窗口其实很像。滑动窗口法是去主动限流，而TCP的滑动窗口则是接收方为了告诉发送方自己还能接受多少数据，是对发送方的“限流
     *
     * 在滑动窗口法中，因为要倒推窗口的开始期，所以需要记录每个请求的执行时间，会额外占用一些内存
     *
     * 此外，在算法中会频繁地removeFirst与addLast，在选择错误的数据结构下（例如数组），可能会造成很大的移动开销。
     */

}
