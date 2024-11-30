package com.example.algorithm.kamaCoder.hot100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReconstructQueue1 {
    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] res = getReuslt(people);
    }

    private static int[][] getReuslt(int[][] people) {
        if (people.length == 0) {
            return new int[0][];
        }

        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];//身高相同 k值升序
            }
            return b[0] - a[0];//身高降序
        });

        LinkedList<int[]> temp = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            int[] person = people[i];
            temp.add(person[1], person);//Linkedlist.add(index, value)，會將value插入到指定index裡。
        }
        return temp.toArray(new int[people.length][]);
    }
}
