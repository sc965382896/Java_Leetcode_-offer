package LeetCode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode pHead = null;
        if (l1.val < l2.val) {
            pHead = l1;
            l1 = l1.next;
        } else {
            pHead = l2;
            l2 = l2.next;
        }
        ListNode pNode = pHead;
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
        return pHead;
    }
}