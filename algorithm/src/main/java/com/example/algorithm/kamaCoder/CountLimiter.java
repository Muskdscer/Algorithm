package com.example.algorithm.kamaCoder;

//计数器法
public class CountLimiter {

    /**
     * 时间间隔窗口
     */
    private long intervalWindow;

    /**
     * 改窗口最大请求数
     */
    private int max;


    /**
     * 当前窗口内的请求计数
     */
    private int count;
    /**
     * 当前窗口内的第一个请求的时间
     */
    private long firstReqTime = System.currentTimeMillis();

    public CountLimiter(long intervalWindow, int max) {
        this.intervalWindow = intervalWindow;
        this.max = max;
    }

    //省略get set方法
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

    /**
     *如果需要进行分布式限流，可以使用Redis。以接口名称作为key，max作为value，intervalWindow作为key过期时间。
     *
     * 当请求过来时，如果key不存在，则代表已经进入下一个窗口，value赋值为max-1，并允许请求通过。
     *
     * 如果key存在，则再判断value是否大于0。大于0则允许请求通过，否则进行限流。
     *
     * 使用Redis进行分布式限流，需要注意保证代码的原子性，可以直接使用lua脚本。
     *
     * 固定窗口法是以第一个请求为窗口开始期，并向后截取intervalWindow长度，只有当窗口时间流逝完，才开辟新的窗口。
     *
     * 滑动窗口法以每一个请求为窗口结束期，向前截取intervalWindow长度，检查该范围内的请求总和，相当于会为每个请求开辟一个新窗口。
     */

}
