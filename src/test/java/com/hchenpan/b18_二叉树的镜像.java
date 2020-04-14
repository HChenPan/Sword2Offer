package com.hchenpan;

import org.junit.Test;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b18_二叉树的镜像
 * Description :
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/2 下午 10:55
 **/
public class b18_二叉树的镜像 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    @Test
    public void test() {
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        TreeNode head = new TreeNode();
        head.val = 8;
        head.left = new TreeNode();
        head.left.val = 6;
        head.left.left = new TreeNode();
        head.left.left.val = 5;
        head.left.right = new TreeNode();
        head.left.right.val = 7;
        head.right = new TreeNode();
        head.right.val = 10;
        head.right.left = new TreeNode();
        head.right.left.val = 9;
        head.right.right = new TreeNode();
        head.right.right.val = 11;
        printBinaryTree(head);
        System.out.println();
        Mirror(head);
        printBinaryTree(head);
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }

    private static final int NODE_LENGTH = 17;      //二叉树中每个结点的长度

    public static void printBinaryTree(TreeNode head) {

        System.out.println("Binary Tree：");
        printInOrder(head, 0, "*");
        System.out.println();
    }

    private static void printInOrder(TreeNode head, int height, String to) {
        if (head == null) {
            return;
        }
        printInOrder(head.left, height + 1, "~");
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (NODE_LENGTH - lenM) / 2;
        int lenR = NODE_LENGTH - lenL - lenM;
        val = getSpace(height * NODE_LENGTH + lenL) + val + getSpace(lenR);
        System.out.println(val);
        printInOrder(head.right, height + 1, "_");
    }

    private static String getSpace(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}