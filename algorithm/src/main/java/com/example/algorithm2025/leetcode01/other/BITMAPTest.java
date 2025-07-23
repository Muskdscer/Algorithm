package com.example.algorithm2025.leetcode01.other;


import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;



public class BITMAPTest {
    private static StringRedisTemplate redisTemplate;
    private static RedisConnection redisConnection;
    public static void main(String[] args) {
        //使用 setbit 命令可以将某个索引设置为 1（设置 0 表示抹去标记）
        redisTemplate.opsForValue().setBit("bit_test", 2L, true);
        redisTemplate.opsForValue().setBit("bit_test", 8L, true);
        //使用 getbit 命令可以判断某个索引是否存在
        Boolean bitTest1 = redisTemplate.opsForValue().getBit("bit_test", 2L);
        Boolean bitTest2 = redisTemplate.opsForValue().getBit("bit_test", 8L);
        Boolean bitTest3 = redisTemplate.opsForValue().getBit("bit_test", 3L);
        //使用 bitcount 命令可以统计某个键中为 1 的比特位个数
        redisConnection.bitCount("bit_test".getBytes());
        System.out.println("位图是： " + bitTest1);
        System.out.println("位图是： " + bitTest2);
        System.out.println("位图是： " + bitTest3);
    }

}
