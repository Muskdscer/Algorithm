package com.example.algorithm.kamaCoder.stackAndQue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopK {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] result = topKFrequentNums(nums, 2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] topKFrequentNums(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}
