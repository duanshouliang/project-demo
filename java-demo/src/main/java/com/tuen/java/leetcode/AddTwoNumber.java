package com.tuen.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表中两数据相加
 */
public class AddTwoNumber {
    public static void main(String[] args) {
        int[] l1 = new int[]{9, 9, 9};
        int[] l2 = new int[]{9, 9};
        System.out.println(solution(l1, l2));
    }

    static List<Integer> solution(int[] l1, int[] l2) {
        int len_1 = l1.length;
        int len_2 = l2.length;
        int len = len_1 > len_2 ? len_1 : len_2;
        int carry = 0;
        int i = 0;
        List<Integer> res = new ArrayList<>();
        while (i < len) {
            int v1 = 0;
            int v2 = 0;
            if (i < len_1) {
                v1 = l1[i];
            }
            if (i < len_2) {
                v2 = l2[i];
            }
            int sum = (v1 + v2 + carry) % 10;
            res.add(sum);
            carry = (v1 + v2 + carry) / 10;
            i++;
        }
        if (carry != 0) {
            res.add(carry);
        }
        return res;
    }

    static ListNode solution2(ListNode l1, ListNode l2) {
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
            carry = sum / 10;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2= l2.next;
            }
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
