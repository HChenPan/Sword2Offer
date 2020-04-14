package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b38_二叉树的深度
 * Description : 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/9 下午 09:37
 **/
public class b38_二叉树的深度 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(TreeDepth(root));
    }

    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}