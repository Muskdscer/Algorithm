package com.example.algorithm.kamaCoder.hash;
import java.lang.*;
import java.util.*;
import java.io.*;


public class TwoSum {
    static int[] res = new int[2];
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] result =  twoSum(nums, 9);
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //map的key是temp
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            //如果temp有target - nums[i];  遇到nums[i]正好可以
            map.put(nums[i], i);
        }
        return res;
    }
}
