package linked_list_cycle;

import java.util.*;

/**
 * @Description:
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @author: lucachen
 * @Date: 2021-04-06
 */
public class Solution {
    /**
     * 哈希表
     * 时间复杂度：n
     * 空间复杂度：n
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (!nodeSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


    /**
     * 快慢指针
     * 如果存在环，一定会在某一刻相遇
     * 时间复杂度：n
     * 空间复杂度：1
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


}
