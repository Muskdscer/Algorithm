package com.example.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    //保持前几题一贯的格式， initialization
    List<List<String>> res = new ArrayList<>();
    List<String> cur = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracking(s, 0, new StringBuilder());
        return res;
    }

    private void backtracking(String s, int start, StringBuilder sb) {
        //因为是起始位置一个一个加的，所以结束时start一定等于s.length,因为进入backtracking时一定末尾也是回文，所以cur是满足条件的
        if (start == s.length()){
            //注意创建一个新的copy
            res.add(new ArrayList<>(cur));
            return;
        }
        //像前两题一样从前往后搜索，如果发现回文，进入backtracking,起始位置后移一位，循环结束照例移除cur的末位
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (check(sb)) {
                cur.add(sb.toString());
                backtracking(s, i + 1, new StringBuilder());
                cur.remove(cur.size() -1 );
            }
        }
    }

    private boolean check(StringBuilder sb) {
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
