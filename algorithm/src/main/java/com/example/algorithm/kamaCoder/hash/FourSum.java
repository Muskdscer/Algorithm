package com.example.algorithm.kamaCoder.hash;

import java.lang.*;
import java.util.*;
import java.io.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{-2,-1};
        int[] nums3 = new int[]{-1, 2};
        int[] nums4 = new int[]{0, 2};

        int count = fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println("共有" + count + "种组合");
    }

    private static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int sum1 = nums1[i] + nums2[j];
                //getOrDefault 存在key返回value,不存在返回默认值
                //value存次数
                map.put(sum1, map.getOrDefault(sum1, 0) + 1);
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int sum2 = nums3[i] + nums4[j];
                //出现一个0 - sum2加一次  加一次0 - sum2对应次数
                res += map.getOrDefault(0 - sum2, 0);
            }
        }
        return res;
    }
}
