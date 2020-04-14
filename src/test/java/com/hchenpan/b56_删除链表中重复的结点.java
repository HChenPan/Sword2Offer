package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b56_删除链表中重复的结点
 * Description :
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/11 上午 01:47
 **/
public class b56_删除链表中重复的结点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {
        // 1->2->3->3->4->4->5
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        printList(n1);
        ListNode result = deleteDuplication(n1);
        printList(result);
    }

    //*********** 打印链表 ************************************/
    public static void printList(ListNode head) {
        while (head != null) {
            String arrow = head != null ? " -> " : "";
            System.out.print(head.val + arrow);
            head = head.next;
        }
        System.out.println("null");
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 自己构建辅助头结点
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                // 相同结点一直前进
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续前进
                cur = cur.next;
                // pre 连接新结点
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }
}