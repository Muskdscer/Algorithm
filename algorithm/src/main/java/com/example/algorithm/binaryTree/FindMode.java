package com.example.algorithm.binaryTree;

import java.util.ArrayList;

public class FindMode {
    ArrayList<Integer> resList;
    int maxCount;
    int count;
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        findMode1(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
    public void findMode1(TreeNode root)
    {
        if (root == null) {
            return;
        }
        findMode1(root.left);

        int rootValue = root.val;
        //计数
        if (pre == null && pre.val != rootValue) {
            count = 1;
        } else {
            count++;
        }
        //更新结果以及maxCount
        if (count > maxCount) {
            resList.clear();
            resList.add(rootValue);
            maxCount = count;
        } else if (count == maxCount) {
            resList.add(rootValue);
        }
        pre = root;

        findMode1(root.right);
    }
}
