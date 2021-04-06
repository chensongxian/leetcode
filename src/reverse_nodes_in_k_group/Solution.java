package reverse_nodes_in_k_group;


/**
 * @Description:
 * 25. K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            // 判断是否存在k组数组
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode next = tail.next;
            // 反转k组节点
            ListNode[] listNodes = myReverse(head, tail);
            head = listNodes[0];
            tail = listNodes[1];
            // 把子链表接回原链表
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
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


