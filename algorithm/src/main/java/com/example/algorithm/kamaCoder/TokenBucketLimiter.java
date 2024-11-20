package com.example.algorithm.kamaCoder;

/**
 * 令牌桶限流
 *
 * 首先有一个令牌桶，然后系统以一个恒定的速率向桶中放入令牌。当桶满时，会丢弃生成的令牌。
 *
 * 每有一个请求过来时，拿到令牌就可以执行，否则阻塞获取或者被直接丢弃。
 */
public class TokenBucketLimiter {
    /**
     * 上次请求到来的时间
     */
    private long preTime = System.currentTimeMillis();
    /**
     * 放入令牌速率,n/s
     */
    private int putRate;
    /**
     * 令牌桶容量
     */
    private int capacity;
    /**
     * 当前令牌数
     */
    private int bucket;

    public TokenBucketLimiter(int putRate, int capacity) {
        this.putRate = putRate;
        this.capacity = capacity;
    }

    //省略get set方法
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

    /**
     * 令牌桶和漏桶的原理有些相似。
     *
     * 漏桶是以一个恒定速率的出水，即处理请求的速率是恒定的。而令牌桶则是以一个恒定的速率往桶中放入令牌，在桶中令牌用完之前，并不限制处理请求的速率。
     *
     * 令牌桶的一个优势在于，可以允许短时间内的一次突发流量。但不会允许在短时间内的多次突发流量，因为令牌的填充也是需要时间的。
     *
     * Guava中的RateLimiter
     *
     * google的工具包Guava中的RateLimiter就是对令牌桶的实现，其包含了两种限流模式，位置处于SmoothRateLimiter的两个静态内部类中：
     *
     * SmoothBursty，稳定模式，令牌生成的速率是恒定的，为默认模式。
     *
     * SmoothWarmingUp，预热模式，逐渐提升令牌的生成速率到一固定值。
     *
     * 其中acquire方法支持阻塞式获取，tryAcquire支持获取不到就返回或者在指定时间内阻塞获取。
     *
     * 以上的RateLimiter属于单机式限流，如果要进行分布式限流该怎么处理呢？
     *
     * 无非是将控制请求的阈值从单机中挪到统一的中间件上，例如Redis。
     *
     * 对于计数器法  如果要限制一天中对某个接口的调用次数，则可以使用接口的名称作为key，value作为预设的阈值，过期时间为24小时。
     * 请求到来时利用原子指令判断key是否存在，不存在则设置该key；存在则减1，再判断是否大于0。
     *
     * 对于滑动窗口法
     * 单机中我们使用list，在分布式系统中，则可以使用Redis的有序集合zset，key为某个接口名称，value为处理请求的时间戳。
     * 请求到来时，先使用removeRangeByScore移除上一个时间窗口内的记录，接着使用size获取集合长度，若大于阈值，则进行限流。
     *
     *对于漏桶法
     * 阿里巴巴的开源分布式限流系统Sentienel，支持漏桶与令牌桶算法。
     *
     * 对于令牌桶法
     * 可以在每个应用中起一个延时的线程池，定时生产令牌到Redis中，这种方案在水平扩展时可以同比例的扩大限流阈值，但性能不高。
     * 当然也可以利用lua脚本，在lua脚本中直接将生产令牌与获取令牌的操作合在一起，即和上文的demo一样，先放入令牌再获取令牌。
     * 之后将脚本放在代码中，每个应用先判断Redis中是否存在该脚本，若不存在再加载该脚本，后续获取令牌时直接执行该脚本即可。
     */
}
