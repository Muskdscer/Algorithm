package com.example.algorithm.demo1;

import java.util.ArrayList;

public class Demo2 {
    byte[] array = new byte[1*1024*1024];//1m

    //Dump文件  -Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
    public static void main(String[] args) {
        ArrayList<Demo2> list = new ArrayList<>();
        int count = 0;

        try {
            while (true) {
                list.add(new Demo2());
                count = count + 1;
            }
        } catch (Exception e) {
            System.out.println("count: " + count);
            e.printStackTrace();
        }
    }
}
