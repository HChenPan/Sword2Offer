package com.hchenpan;

import org.junit.Test;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b16_合并两个排序的链表
 * Description :
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/2 下午 02:37
 **/
public class b16_合并两个排序的链表 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(5);
        head2.next.next.next = new ListNode(6);
        head2.next.next.next.next = new ListNode(7);
        printList(head2);
        head = Merge(head, head2);
        printList(head);
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode mergeHead = null;//合并后新链表的头结点
        ListNode current = null;  //新链表的当前节点
        while (list1 != null && list2 != null) {
            ListNode temp;
            if (list1.val <= list2.val) {
                temp = list1;       //小元素暂存
                list1 = list1.next; //链表后移
            } else {
                temp = list2;
                list2 = list2.next;
            }
            if (mergeHead == null) {
                mergeHead = current = temp;      //初始化新链表 小元素赋给合并链表
            } else {
                current.next = temp;            //小元素插入新链表当前节点下一个节点
                current = current.next;   //新链表后移
            }
        }
        if (list1 == null) {
            //1号链表遍历结束 2号链表挂在新链表后面
            current.next = list2;
        } else {
            current.next = list1;
        }
        return mergeHead;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            String arrow = head != null ? " -> " : "";
            System.out.print(head.val + arrow);
            head = head.next;
        }
        System.out.println("null");
    }
}