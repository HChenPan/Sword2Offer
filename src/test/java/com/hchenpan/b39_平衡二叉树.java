package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b39_平衡二叉树
 * Description : 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/9 下午 09:44
 **/
public class b39_平衡二叉树 {
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

    }

    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null || !isBalanced) {
            return 0;
        }
        int left = height(root.left);//当前根节点左子树高度
        int right = height(root.right);//当前根节点右子树高度
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(left, right);           //返回当前根节点左右子树最大高度
    }
}