package com.example.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        //递归方式
        //checkFun01(root,0);
        //迭代方式
        checkFun02(root);
        return resList;
    }

    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null) {return;}
        deep++;
        if (resList.size() < deep) {
            //当层数增加时，list的item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);
        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }
    public void checkFun02(TreeNode node) {
        if (node == null) {return;}
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();
            while (len > 0) {
                TreeNode temp = que.poll();
                itemList.add(temp.val);
                if (temp.left != null) {
                    que.offer(temp.left);
                }
                if (temp.right != null) {
                    que.offer(temp.right);
                }
                len--;
            }
            resList.add(itemList);
        }
    }
}
