package com.leetcode.leetcode;


/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 题目解析：
 * 给定两个代表两个非负数的链表，按数位逆置方式存储（即123存储为3→2→1→NULL），要求返回两数之和的的反向链表
 * <p>
 * <p>
 * <p>
 * Input:[1,8]
 * [0]
 * ​Expected:[1,8]
 * <p>
 * ​2、两边输入的数量可能不同
 * ​Input:[5]
 * [5]​
 * ​Expected:[0,1]​
 * ​
 * Input:[8,9,9]
 * [2]
 * ​Expected:[0,0,0,1]​
 *
 * @author duchu
 * @date 2019/5/8 7:55 AM
 */
public class AddTwoNumbers {


    /**
     * 思路:
     * 1、数组反转后，从头开始取，取出来刚好是从个位开始
     * 2、将取出来的数值相加，相加后如果大于10则进到下一位参与运算
     *
     * 注意链表长度不一致或进位后多一位的场景
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = l1.val + l2.val;
        /*进入下一位的运算值*/
        int carry = sum / 10;
        /*当前位的数值*/
        int currentBitValue = sum % 10;

        ListNode listNode = new ListNode(currentBitValue);
        ListNode tailNode = listNode;

        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {

            sum = l1.val + l2.val;
            currentBitValue = (sum + carry) % 10;
            carry = (sum + carry) / 10;

            ListNode newTail = new ListNode(currentBitValue);
            tailNode.next = newTail;
            tailNode = newTail;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            currentBitValue = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            ListNode newTail = new ListNode(currentBitValue);
            tailNode.next = newTail;
            tailNode = newTail;
            l1 = l1.next;
        }
        while (l2 != null) {
            currentBitValue = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            ListNode newTail = new ListNode(currentBitValue);
            tailNode.next = newTail;
            tailNode = newTail;
            l2 = l2.next;
        }
        if (carry > 0) {
            ListNode newTail = new ListNode(carry);
            tailNode.next = newTail;
        }


        return listNode;
    }


    public static void main(String[] args) {
//        ListNode listNode = new ListNode(3);
//        listNode.next = new ListNode(4);
//        listNode.next.next = new ListNode(2);
//
//        ListNode listNode2 = new ListNode(4);
//        listNode2.next = new ListNode(6);
//        listNode2.next.next = new ListNode(5);


        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(8);

        ListNode listNode2 = new ListNode(0);

        ListNode listNode1 = addTwoNumbers(listNode, listNode2);
        System.out.print(listNode1);
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

