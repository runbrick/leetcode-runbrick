package com.runbrick.app;

/**
 * 力扣第 2 题: 两数相加
 * 难度：简单
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public static ListNode listNode = new ListNode(2, new ListNode(4, new ListNode(3)));
    public static ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));

    public static void main(String[] args) {
        System.out.println(addTwoNumbers(listNode, listNode2));
    }

    /**
     * 243 + 564 => [3,4,2] [4,6,5] => 807
     * 1. 3 + 4 = 7 , 不大于10
     * 2. 4 + 6 = 10 , 大于 10 进 1 位
     * 3. 3 + 7 = 7 ,因为上一位 进了 1 要在此位 + 1 所以等于 8
     * 最后值等于 [7,0,8]
     *
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
//            carry = sum / 10;
            carry = sum >= 10 ? 1 : 0;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
