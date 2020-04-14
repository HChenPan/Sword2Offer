package com.hchenpan;

import org.junit.Test;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b15_反转链表
 * Description :输入一个链表，反转链表后，输出新链表的表头。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/2 上午 12:32
 **/
public class b15_反转链表 {
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
        printList(head);
        head = ReverseList(head);
        printList(head);

    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode reverseHead = null;//翻转后的链表
        ListNode cur = head;    //当前结点
        ListNode pre = null;    //当前结点的前一个结点
        // pre = null, 因为反转后，head.next = null;
        ListNode next = null;//当前节点的后一个节点
        //eg: 1 2 3 4 5 6
        while (cur != null) {
            //遍历旧链表
            next = cur.next;//当前节点下一个节点赋给后一个节点 next 2 cur 1 | next 3 cur 2
            if (next == null) {
                reverseHead = cur;//旧链表尾节点赋给翻转链表头结点
            }
            cur.next = pre;//翻转当前节点下一个节点是当前节点前节点     pre null cur.next null cur 1 | pre 1 cur.next 1 cur 2
            pre = cur; //当前节点赋给前一个节点                    pre 1 cur 1
            cur = next;  //当前节点后一个节点赋给当前节点           cur 2 next 2
        }
        return reverseHead;
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