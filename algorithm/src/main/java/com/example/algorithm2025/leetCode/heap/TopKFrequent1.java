package com.example.algorithm2025.leetCode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent1 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            pq.add(new int[]{integerIntegerEntry.getKey(), integerIntegerEntry.getValue()}) ;
        }
        int[] ans = new int[k];
        //依次从队头弹出K个
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}
