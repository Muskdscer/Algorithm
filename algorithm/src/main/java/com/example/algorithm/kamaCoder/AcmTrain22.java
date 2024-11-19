package com.example.algorithm.kamaCoder;

import java.util.Scanner;

public class AcmTrain22 {
    static TreeNode[] nodes = new TreeNode[30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int len = sc.nextInt();
            for (int i = 0; i< len; i++) {
                //F23
                char val = sc.next().charAt(0);
                int left = sc.nextInt();
                int right = sc.nextInt();
                if (nodes[i + 1] == null) {
                    nodes[i +1] = new TreeNode('\0');
                } else {
                    nodes[i + 1].val = val;
                }
                //说明有左节点
                if (left != 0) {
                    if (nodes[left] == null) {
                        nodes[left] = new TreeNode('\0');
                    }
                    nodes[i + 1].left = nodes[left];
                }
                if (right != 0) {
                    if (nodes[right] == null) {
                        nodes[right] = new TreeNode('\0');
                    }
                    nodes[i + 1].right = nodes[right];
                }
            }

            preorder(nodes[1]);
            System.out.println();
            inorder(nodes[1]);
            System.out.println();
            postorder(nodes[1]);
        }
    }

    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }
}
