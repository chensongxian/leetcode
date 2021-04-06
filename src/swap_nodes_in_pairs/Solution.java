package swap_nodes_in_pairs;


import java.util.TooManyListenersException;

/**
 * @Description:
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @author: lucachen
 * @Date: 2021-04-06
 */
public class Solution {

    /**
     * 迭代，需要新增一个哑节点，方便处理
     * 注意处理节点交换之后，需要处理上一对节点也发生了交换
     * 需要处理节点关系
     *
     * 时间复杂度：O(n)，其中 n 是链表的节点数量。需要对每个节点进行更新指针的操作。
     *
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    /**
     * 递归
     * 递归解法相当于既能保存历史节点信息，有可以从尾部开始处理节点
     *
     * 时间复杂度：O(n)，其中 n 是链表的节点数量。需要对每个节点进行更新指针的操作。
     *
     * 空间复杂度：O(n)，其中 n 是链表的节点数量。空间复杂度主要取决于递归调用的栈空间。
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 递归
        ListNode newHead = swapPairs2(head.next.next);
        ListNode returnHead = head.next;
        head.next.next = head;
        head.next = newHead;
        return returnHead;
    }
}
