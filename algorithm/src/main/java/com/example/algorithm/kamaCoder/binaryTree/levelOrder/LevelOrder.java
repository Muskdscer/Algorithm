package com.example.algorithm.kamaCoder.binaryTree.levelOrder;

import com.sun.prism.null3d.NULL3DPipeline;

import java.util.*;
import java.io.*;

public class LevelOrder {
    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(char val) {
            this.val = val;
        }
        public TreeNode(TreeNode left, TreeNode right, char val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static Map<Character, Integer> map = new HashMap<>();
    //层序遍历存放二叉树节点
    static List<List<TreeNode>> result = new ArrayList<>();
    //从底向上层序遍历
    static List<List<TreeNode>> reverseResult = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] lines = sc.nextLine().split(" ");
            String pre = lines[0];
            String in = lines[1];

            TreeNode root = build(pre,in);
            List<List<TreeNode>> res = levelOrder(root);
        }
    }

    //层序遍历
    private static List<List<TreeNode>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        if (root == null) {
            return result;
        }

        que.offer(root);
        while (!que.isEmpty()) {
            List<TreeNode> tempList = new ArrayList<>();
            //size决定每一层节点放几次  for循环几次   每放一个把左右孩子都放进来
            int size = que.size();

            //for循环几次同层节点放几个进tempList里面去
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                tempList.add(node);

                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            result.add(tempList);

//            while (size > 0) {
//                if (node.left != null) {
//                    que.add(node.left);
//                }
//                if (node.right != null) {
//                    que.add(node.right);
//                }
//                size--;
//            }

        }

        //求从底向上层序遍历的结果
//        for (int i = result.size() - 1 ; i >= 0; i--) {
//            reverseResult.add(result.get(i));
//        }
//        return reverseResult;
        return result;
    }

    private static TreeNode build(String pre, String in) {
        if (pre.length() == 0 || in.length() == 0) {
            return null;
        }

        for (int i = 0; i < in.length(); i++) {
            map.put(in.charAt(i), i);
        }

        TreeNode root = buildHelper(pre.toCharArray(), 0, pre.length() - 1, in, 0, in.length() -1);
        return root;
    }

    private static TreeNode buildHelper(char[] pre, int preStart, int preEnd, String in, int inStart, int inEnd) {
        if (preStart < 0 || preStart > preEnd || inStart < 0 || inStart > inEnd) {
            return null;
        }
        if (preEnd > pre.length - 1 || inEnd > in.length() - 1) {
            return null;
        }

        char s = pre[preStart];
        TreeNode root = new TreeNode(s);
        int rootIndex = map.get(s);
        int lengthOfLeft = rootIndex - inStart;

        root.left = buildHelper(pre, preStart + 1, preStart + lengthOfLeft, in, inStart, rootIndex - 1);
        root.right = buildHelper(pre, preStart + 1 + lengthOfLeft, preEnd, in, rootIndex + 1, inEnd);
        return root;
    }


}
