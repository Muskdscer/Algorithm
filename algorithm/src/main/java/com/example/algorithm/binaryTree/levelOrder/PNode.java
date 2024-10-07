package com.example.algorithm.binaryTree.levelOrder;

public class PNode {
    int val;
    PNode left;
    PNode right;
    PNode next;

    PNode() {
    }
    PNode(int val) {
        this.val = val;
    }
    PNode(int val, PNode left, PNode right,PNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
