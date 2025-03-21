package com.example.algorithm2025.leetCode.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MutiThreadKafkaConsumer {
    private final KafkaConsumer<String, String> consumer;
    private final ExecutorService executorService;
    public MutiThreadKafkaConsumer() {
        Properties props =new Properties();
        props.put("bootstrap.servers","localhost:9092");
        props.put("group.id","test");
        props.put("enable.auto.commit","true");
        props.put("auto.commit.interval.ms","1000");
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        consumer =new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("tony_topic"));
//创建一个包含20个线程的线程池
        executorService =Executors.newFixedThreadPool(20);
    }
    public void pollMessages(){
        while(true){
            ConsumerRecords<String,String> records =consumer.poll(500L);
            records.forEach(record -> {
                executorService.submit(() -> {
                    //在线程池中处理消息
                    handleMessage(record);
                });
            });
        }
    }

    private void handleMessage(ConsumerRecord<String, String> record) {
        //do something
        System.out.println("Received message: " + record.value());
    }

    public static void main(String[] args) {
        MutiThreadKafkaConsumer consumer1 = new MutiThreadKafkaConsumer();
        consumer1.pollMessages();
    }

}
