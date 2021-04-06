package linked_list_cycle_II;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * 142. 环形链表2
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
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
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (!nodeSet.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 快慢指针
     * 结论：当快慢节点相遇时，指定一个节点从头节点除非，同时slow节点继续走，他们最终会在入环处相遇
     * 具体论证可看 https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
     * 时间复杂度：n
     * 空间复杂度：1
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode pur = head;
                while (pur != slow) {
                    slow = slow.next;
                    pur = pur.next;
                }
                return pur;
            }
        }
        return null;
    }
}
