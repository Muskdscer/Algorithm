package com.example.algorithm2025.leetcode01.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams3 {
    public List<List<String>> groupAnagrams (String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                sb.append((char)(i + 'a'));
                sb.append(count[i]);
            }
            List<String> stringList = map.getOrDefault(sb.toString(), new ArrayList<>());
            stringList.add(str);
            map.put(sb.toString(), stringList);

        }
        return new ArrayList<>(map.values());
    }
}
