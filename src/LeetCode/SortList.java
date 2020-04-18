package LeetCode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int length = getLength(head);
        for (int i = 1; i < length; i <<= 1) {
            ListNode tmp = new ListNode(0);
            ListNode cur = head;
            ListNode pre = tmp;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = cut(cur, i);
                cur = cut(right, i);
                pre.next = mergeLinkedList(left, right);
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
            head = tmp.next;
        }
        return head;
    }
    public ListNode cut(ListNode head, int n) {
        if (head == null)
            return head;
        for (int i = 1; i < n; i++) {
            if (head.next == null) break;
            head = head.next;
        }
        ListNode pNode = head.next;
        head.next = null;
        return pNode;
    }
    public ListNode mergeLinkedList(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(0);
        ListNode pNode = dummyHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                pNode.next = left;
                left = left.next;
            } else {
                pNode.next = right;
                right = right.next;
            }
            pNode = pNode.next;
        }
        pNode.next = left != null ? left : right;
        return dummyHead.next;
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
