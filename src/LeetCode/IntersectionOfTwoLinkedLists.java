package LeetCode;

// 相交链表：寻找相交的第一个节点，不相交返回null。

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        int diff = 0;
        ListNode l = new ListNode(0);
        ListNode s = new ListNode(0);
        if (lengthA > lengthB) {
            diff = lengthA - lengthB;
            l = headA;
            s = headB;
        } else {
            diff = lengthB - lengthA;
            l = headB;
            s = headA;
        }
        for (int i = 0; i < diff; i++) {
            l = l.next;
        }
        while (l != null) {
            if (l == s)
            return l;
            l = l.next;
            s = s.next;
        }
        return null;
    }
    public int getLength(ListNode head) {
        ListNode pNode = head;
        int count = 0;
        while (pNode != null) {
            count++;
            pNode = pNode.next;
        }
        return count;
    }
}
