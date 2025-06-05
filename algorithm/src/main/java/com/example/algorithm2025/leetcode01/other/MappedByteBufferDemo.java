package com.example.algorithm2025.leetcode01.other;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferDemo {
    static int length = 0x8000000; // 128 Mb 一个bit占1B，0x8000000换成十进制为：134217728

    public static void main(String[] args) throws IOException {

//        File file = new File("C:\\Users\\admin\\Desktop\\test.txt");
//        if (!file.exists()) {
//            boolean mkdirs = file.mkdirs();
//        }
//        try {
//            System.out.println("开始写入");
//            FileWriter fileWriter = new FileWriter(file);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            for (int i = 0; i < 90000000; i++) {
//                bufferedWriter.write("abcdefghi!");
//            }
//            bufferedWriter.close();
//            fileWriter.close();
//            System.out.println("写入结束");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



//        try {
//            System.out.println("开始写入");
//            // 为了以可读可写的方式打开文件，我们使用RandomAccessFile来创建文件
//            FileChannel rw = new RandomAccessFile("C:\\Users\\admin\\Desktop\\test.txt", "rw").getChannel();
//            //文件通道的可读可写要建立在文件流本身可读写的基础之上
//            MappedByteBuffer map = rw.map(FileChannel.MapMode.READ_WRITE, 0, length);
//            //写128M的内容*（a）
//            for (int i = 0; i < length; i++) {
//                map.put((byte) 'a');
//            }
//            System.out.println("writing end");
//            //读取文件中间20个字节内容
//            for (int i = length / 2; i < length / 2 + 20; i++) {
//                System.out.println((char) map.get(i));
//            }
//            rw.close();
//            System.out.println("写入结束");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



//        File sourceFile = new File("C:\\Users\\admin\\Desktop\\test.txt");
//        FileInputStream fis = new FileInputStream(sourceFile);
//        FileChannel fisChannel = fis.getChannel();
//        FileOutputStream fos = new FileOutputStream("C:\\Users\\admin\\Desktop\\test1.txt");
//        FileChannel fosChannel = fos.getChannel();
//        fisChannel.transferTo(0, fisChannel.size(), fosChannel);
//        fis.close();
//        fos.close();



        File sourceFile = new File("C:\\Users\\admin\\Desktop\\test.txt");
//        byte[] bytes = new byte[1024];  // 和下面方式创建byte[]效率基本一样
        byte[] bytes = new byte[(int) sourceFile.length()];
        RandomAccessFile ra_read = new RandomAccessFile(sourceFile, "r");
        FileChannel fc = new RandomAccessFile("C:\\Users\\admin\\Desktop\\test1.txt", "rw").getChannel();
        MappedByteBuffer map = fc.map(FileChannel.MapMode.READ_WRITE, 0, sourceFile.length());
        int len = -1;
        System.out.println("开始写入");
        while ((len = ra_read.read(bytes)) != -1) {
            map.put(bytes, 0, len); // 写入数据
        }
        ra_read.close();
        fc.close();
        System.out.println("写入结束");
    }
}
