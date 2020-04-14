package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b57_二叉树的下一个结点
 * Description :
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/11 上午 01:55
 **/
public class b57_二叉树的下一个结点 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;// 指向父结点的指针

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {

    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            //如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while (pNode.next != null) {
                //否则，向上找 第一个左链接 指向的树 包含 该节点 的 祖先节点
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }
}