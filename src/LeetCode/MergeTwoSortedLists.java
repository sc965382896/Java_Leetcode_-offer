package LeetCode;

//
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pHead = new ListNode(0);
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
        return pHead.next;
    }
}
