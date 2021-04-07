package reverse_nodes_in_k_group;


import java.util.Timer;

/**
 * @Description:
 * 25. K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @author: lucachen
 * @Date: 2021-04-06
 */
public class Solution {

    /**
     * 时间复杂度：n
     * 空间复杂度：1
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode prev = hair;

        while (head != null) {
            ListNode tail = prev;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] listNodes = myReverse(head, tail);
            head = listNodes[0];
            tail = listNodes[1];
            // 把链表连接到原有链表，
            prev.next = head;
            // 可不要，myReverse 中已处理
            tail.next = next;

            prev = tail;
            // 等价于 head = tail.next
            head = next;
        }
        return hair.next;
    }

    /**
     * 递归1
     * 先反转，再递归
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0 ; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup1(tail, k);
        return newHead;
    }


    /**
     * 递归2
     * 先递归，再反转，反转时把头节点指向递归返还值
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0 ; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode pre = reverseKGroup2(tail, k);
        ListNode newHead = reverse1(head, tail, pre);
        return newHead;
    }


    private ListNode reverse1(ListNode head, ListNode tail, ListNode pre) {
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }



    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }



}


