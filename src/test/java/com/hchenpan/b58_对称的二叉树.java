package com.hchenpan;

import org.junit.Test;

import java.util.Stack;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b58_对称的二叉树
 * Description : 实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/11 上午 02:03
 **/
public class b58_对称的二叉树 {
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
        //                            1
        //                  2                   2
        //             4         6          6          4
        //          8     9   10   11   11     10   9     8

    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        Stack<TreeNode> s = new Stack<>();
        s.push(pRoot.left);
        s.push(pRoot.right);
        while (!s.empty()) {
            TreeNode right = s.pop();//成对取出
            TreeNode left = s.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            //成对插入
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;
    }

}