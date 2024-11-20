package com.example.algorithm.kamaCoder;

/**
 * 漏桶限流
 *
 *
 * 如果储蓄桶满了之后，再进来的水会全部溢出。只有当出水速率和漏水速率相同时，储蓄桶才会在不漏水的前提下达到最大的吞吐量
 *
 *
 * 我们把水比作请求，水龙头就是客户端。请求产生的速率肯定不是恒定的，但处理请求的速率是恒定的。当储蓄桶满了之后，请求产生的速率必须要和处理请求的速率一致
 */
public class LeakyBucketLimiter {

    /**
     * 上次请求到来的时间
     */
    private long preTime = System.currentTimeMillis();

    /**
     * 漏水速率,n/s
     */
    private int leakRate;

    /**
     * 储蓄桶容量
     */
    private int capacity;

    /**
     * 当前水量
     */
    private int water;

    public LeakyBucketLimiter(int leakRate, int capacity)
    {
        this.leakRate = leakRate;
        this.capacity = capacity;
    }

    //省略get set方法

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

    /**
     * 储蓄桶能够把不定速率的请求转化为恒定速率的请求，和消息队列一样，具有削峰填谷的作用
     *
     * 其实整套装置和ScheduledThreadPoolExecutor线程池更像，将储蓄桶想象为具有延时特性的阻塞队列，超出队列容量的请求，将直接执行拒绝策略。
     *
     * 如果储蓄桶的容量为Integer.MAX_VALUE，流速为10/s，则可通过以下的代码来模拟漏桶：
     *
     *         //最大任务数为Integer.MAX_VALUE,即储蓄桶容量
     *         ScheduledExecutorService pool = Executors.newScheduledThreadPool(30);
     *         //每隔0.1秒处理1个请求,即流速为10/s
     *         pool.scheduleAtFixedRate(() -> System.out.println("处理请求"), 0, 100, TimeUnit.MILLISECONDS);
     *
     * 使用漏桶法去做限流，在业务平稳期其实已经够用了。但是在业务高峰期，我们又希望动态地去调整处理请求的速率，而不是一成不变的速率。
     *
     *我们大可以动态地去改变参数leakRate的值，不过在计算剩余水量的时候，将会十分复杂。
     *
     * 因此，如果要考虑到对突发流量的控制，就不太推荐漏桶法了。
     */

}
