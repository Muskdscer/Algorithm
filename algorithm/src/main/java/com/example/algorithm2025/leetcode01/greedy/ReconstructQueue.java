package com.example.algorithm2025.leetcode01.greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {return o1[1] - o2[1];};
            //降序
            return o2[0] - o1[0];
        });
        LinkedList<int[]> ans = new LinkedList<>();
        for (int[] p : people) {
            ans.add(p[1], p);
        }
        return ans.toArray(new int[people.length][]);
    }
}
