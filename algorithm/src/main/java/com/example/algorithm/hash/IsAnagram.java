package com.example.algorithm.hash;

public class IsAnagram {

    /**
     * 有效字母异位词 字典解法
     * 时间复杂度：O(m+n)  空间复杂度：O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (record[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
