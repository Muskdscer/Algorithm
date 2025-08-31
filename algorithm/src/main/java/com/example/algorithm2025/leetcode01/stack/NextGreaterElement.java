package com.example.algorithm2025.leetcode01.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> temp = new Stack<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0 ; i< nums1.length ; i++){
            hashMap.put(nums1[i],i);
        }
        temp.add(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[temp.peek()]) {
                temp.add(i);
            } else {
                while (!temp.isEmpty() && nums2[temp.peek()] < nums2[i]) {
                    if (hashMap.containsKey(nums2[temp.peek()])) {
                        Integer index = hashMap.get(nums2[temp.peek()]);
                        res[index] = nums2[i];
                    }
                    temp.pop();
                }
                temp.add(i);
            }
        }
        return res;
    }
}
