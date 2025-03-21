package com.example.algorithm2025.leetCode.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import javax.xml.datatype.Duration;
import java.util.Arrays;
import java.util.Properties;

public class SingleThreadKafkaConsumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers","localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("tony_topic"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(500L);
            for (ConsumerRecord<String, String> record : records) {
                //处理消息逻辑
                System.out.println("Received message：" + record.value());
            }
        }

    }
}
