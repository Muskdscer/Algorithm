package com.example.algorithm.kamaCoder.hot100;

import java.lang.*;
import java.io.*;
import java.util.*;

public class PartitionLabels {
    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        List<Integer> res = getResult(str);
        List<Integer> result = partitionLabels(str);
    }

    private static List<Integer> partitionLabels(String str) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(idx,edge[chars[i] - 'a']);
            if (i == idx) {
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }

    private static List<Integer> getResult(String str) {
        List<Integer> res = new ArrayList<>();
        int[] temp =  new int[26];
        for (int i = 0; i < str.length(); i++) {
            temp[str.charAt(i) - 'a'] = i;
        }
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (temp[str.charAt(i) - 'a'] == i) {
                res.add(i - start);
                start = i;
            }
        }
        return res;
    }
}
