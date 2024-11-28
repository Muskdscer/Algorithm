package com.example.algorithm.kamaCoder.hot100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Spliterator;

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        //身高从打到小排列
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] person : people) {
            que.add(person[1], person);
        }
        return que.toArray(new int[people.length][]);
    }
}
