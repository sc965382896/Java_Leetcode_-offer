package jianzhiOffer;

// 合并两个排序链表
// 引入一个哨兵节点，减少代码量。

public class Solution25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode pNode = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pNode.next = l1;
                l1 = l1.next;
                pNode = pNode.next;
            } else {
                pNode.next = l2;
                l2 = l2.next;
                pNode = pNode.next;
            }
        }
        if (l1 != null)
            pNode.next = l1;
        if (l2 != null)
            pNode.next = l2;
        return dummyHead.next;
    }
}
