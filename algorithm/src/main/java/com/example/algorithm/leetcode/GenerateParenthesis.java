package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    List<String> ans = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, sb);
        return ans;
    }

    private void dfs(int left, int right, StringBuilder temp) {
        if (left == 0 && right == 0) {
            ans.add(temp.toString());
            return;
        }
        if (left > 0) {
            temp.append("(");
            dfs(left - 1, right + 1, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
        if (right > 0) {
            temp.append(")");
            dfs(left, right - 1, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
