package com.hchenpan;

import org.junit.Test;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b14_链表中倒数第k个结点
 * Description : 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/1 下午 11:21
 **/
public class b14_链表中倒数第k个结点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println(FindKthToTail(head, 1).val);   //倒数第1个
        System.out.println(FindKthToTail(head, 3).val);   //中间的一个
        System.out.println(FindKthToTail(head, 6).val);   //倒数最后一个就是顺数第一个
        System.out.println(FindKthToTail(head, 10).val);
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        //p2先跑K位
        for (int i = 1; i < k; i++) {
            if (p2.next != null) {
                p2 = p2.next;
            } else {
                return null;
            }
        }
        //p1`p2同时跑K位
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}