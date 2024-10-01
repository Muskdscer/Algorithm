package com.example.algorithm.greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        //身高从大到小排列(身高相同，k小的站前面)
        Arrays.sort(people,(a,b) ->{
            if (a[0] == b[0]) {// a - b 是升序排列，故在a[0] == b[0]的狀況下，會根據k值升序排列
                return a[1] - b[1];
            }
            return b[0] - a[0];//b - a 是降序排列，在a[0] != b[0]，的狀況會根據h值降序排列
        });
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] person : people) {
            que.add(person[1],person);//Linkedlist.add(index, value)，會將value插入到指定index裡。
        }
        return que.toArray(new int[people.length][]);
    }
}
