package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b55_链表中环的入口结点
 * Description : 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/11 上午 01:26
 **/
public class b55_链表中环的入口结点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {
        // 1->2->3->4->5->6
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        System.out.println(EntryNodeOfLoop(n1));
        // 1->2->3->4->5->6
        //       ^        |
        //       |        |
        //       +--------+
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;
        System.out.println(EntryNodeOfLoop(n1).val);
        // 1->2->3->4->5->6 <-+
        //                |   |
        //                +---+
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n6;
        System.out.println(EntryNodeOfLoop(n1).val);
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        //假设存在环
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;//遍历速度为2
            slow = slow.next;//遍历速度为1
            // 最终都会停留在环中
        } while (slow != fast);
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;//一直在环中
            fast = fast.next;//从环外入环
        }
        return slow;
    }
}