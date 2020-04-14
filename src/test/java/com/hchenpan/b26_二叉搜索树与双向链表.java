package com.hchenpan;

import org.junit.Test;

import java.util.Stack;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b26_二叉搜索树与双向链表
 * Description :
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/5 下午 03:52
 **/
public class b26_二叉搜索树与双向链表 {
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
        //            10
        //         /      \
        //        6        14
        //       /\        /\
        //      4  8     12  16
        TreeNode node10 = new TreeNode(10);
        TreeNode node6 = new TreeNode(6);
        TreeNode node14 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node12 = new TreeNode(12);
        TreeNode node16 = new TreeNode(16);
        node10.left = node6;
        node10.right = node14;
        node6.left = node4;
        node6.right = node8;
        node14.left = node12;
        node14.right = node16;
        System.out.println("inOrderTraversal: ");
        inOrderPrint(node10);
        TreeNode head = Convert(node10);
        System.out.println();
        printDoubleLinkedList(head);
    }

    public static void inOrderPrint(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderPrint(head.left);
        System.out.print(head.val + " ");
        inOrderPrint(head.right);
    }

    public static void printDoubleLinkedList(TreeNode head) {
        System.out.println("Double Linked List: ");
        TreeNode end = null;
        while (head != null) {
            System.out.print(head.val + " ");
            end = head;
            head = head.right;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.val + " ");
            end = end.left;
        }
        System.out.println();

    }

    /**
     * description(描述)
     * 遍历右分支入栈
     * 从最右节点出栈，出栈节点存入链表，并设置双向指针
     * 移动到当前节点左节点 重复操作，直至遍历到最左节点
     * 最终链表指向最小节点
     *
     * @param pRootOfTree 参数
     * @return com.hchenpan.b26_二叉搜索树与双向链表.TreeNode
     * @author Huangcp
     * @date 2020/4/5 下午 05:34
     **/
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        //    10
        //   /  \
        //  6    14
        // /\    /\
        //4  8 12  16
        TreeNode list = null;
        Stack<TreeNode> stack = new Stack<>();
        while (pRootOfTree != null || !stack.isEmpty()) {
            //中序遍历
            if (pRootOfTree != null) {
                //pRootOfTree null       12        6
                //stack       10->14->16 10->12    6->8
                //list        null       16->14    16->14->12->10
                stack.push(pRootOfTree);//节点入栈
                pRootOfTree = pRootOfTree.right;//遍历右分支
            } else {
                //pRootOfTree null         null    null   null           6
                //stack       10->14->16   10->14  10->12 10             6->8
                //list        null         16      16->14 16->14->12     16->14->12->10
                pRootOfTree = stack.pop();//出栈
                //pRootOfTree 16           14     12      10              8
                //stack       10->14       10     10      null            6
                //list        null         16     16->14  16->14->12      16->14->12->10
                if (list != null) {
                    list.left = pRootOfTree;//链表left挂载节点
                    pRootOfTree.right = list;//节点right挂载链表
                }
                list = pRootOfTree;//链表挂载节点
                //pRootOfTree 16           14      12         10
                //stack       10->14       10      10         null
                //list        16           16->14  16->14->12 16->14->12->10
                pRootOfTree = pRootOfTree.left;//遍历左分支
                //pRootOfTree null         12      null        6
                //stack       10->14       10      10          null
                //list        16           16->14  16->14->12  16->14->12->10 16->14->12->10->8 16->14->12->10->8->6 16->14->12->10->8->6->4
            }
        }
        return list;
    }

}