package com.hchenpan;

import org.junit.Test;

import java.util.Stack;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b63_二叉搜索树的第k个结点
 * Description : 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/11 下午 04:03
 **/
public class b63_二叉搜索树的第k个结点 {
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
        //            8
        //        6      10
        //       5 7    9  11
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(11);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println(KthNode(n1, 4).val);
        System.out.println(KthNode(n1, 6).val);
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode node = pRoot;
        //中序遍历 出栈顺序是递增的
        do {
            if (node != null) {
                stack.push(node);//入栈
                node = node.left;//左移
            } else {
                node = stack.pop();//出栈
                count++;//第 count 小的元素出栈了
                if (count == k) {
                    return node;
                }
                node = node.right;//右移
            }
        } while (node != null || !stack.isEmpty());
        return null;
    }
}