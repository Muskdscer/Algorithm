package com.example.algorithm.kamaCoder.binaryTree;

public class DeleteNode {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        TreeNode newRoot = delete(root, 2);
    }

    private static TreeNode delete(TreeNode root, int val) {
        if (root == null) return root;
        if (root.val == val) {
            if (root.left ==null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                //具体逻辑后面有时间看
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }

        if (root.val > val) root.left = delete(root.left, val);
        if (root.val < val) root.right = delete(root.right, val);
        return root;
    }
}
