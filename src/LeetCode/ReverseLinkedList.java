package LeetCode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pPre = null;
        ListNode pNode = head;
        while (pNode.next != null) {
            ListNode pNext = pNode.next;
            pNode.next = pPre;
            pPre = pNode;
            pNode = pNext;
        }
        pNode.next = pPre;
        return pNode;
    }
}
