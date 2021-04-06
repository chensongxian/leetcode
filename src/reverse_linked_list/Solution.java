package reverse_linked_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author: lucachen
 * @Date: 2021-04-06
 */
public class Solution {
    /**
     * 数组反转，再重新构造链表
     * 时间复杂度：3n
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> nodeValueList = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null){
            nodeValueList.add(currentNode.val);
            currentNode = currentNode.next;
        }
        Collections.reverse(nodeValueList);
        ListNode headNode = new ListNode();
        ListNode parentNode = new ListNode();
        for (int i = 0; i < nodeValueList.size(); i++) {
            if (i == 0) {
                headNode.val = nodeValueList.get(0);
                parentNode = headNode;
            } else {
                ListNode node = new ListNode();
                node.val = nodeValueList.get(i);
                // 设置父节点的next
                parentNode.next = node;
                parentNode = node;
            }
        }
        return headNode;
    }

    /**
     * 用一个临时遍历记录当前节点和下一个节点，将下一个节点的next指向当前节点
     * 关键在于当变更节点指向时，需要记录节点的历史指向
     * 尾节点需要将next设置为空
     * 时间复杂度：n
     * 空间复杂度: 1
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode currentNode = head;
        ListNode next = head.next;
        while (next != null) {
            ListNode oldNext = next.next;
            next.next = currentNode;
            currentNode = next;
            next = oldNext;
        }
        head.next = null;

        return currentNode;
    }

    /**
     * 与2解法相同，只是更加易懂
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    /**
     * 递归
     * 其实递归操作，相当于在栈中记录来node的原始指向关系
     * 时间复杂度：n
     * 空间复杂度：n
     * @param head
     * @return
     */
    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList4(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1  = new ListNode(1);
        ListNode node2  = new ListNode(2);
        ListNode node3  = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5  = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution solution = new Solution();
        ListNode node = solution.reverseList4(node1);
        System.out.println(node.val);

    }
}
