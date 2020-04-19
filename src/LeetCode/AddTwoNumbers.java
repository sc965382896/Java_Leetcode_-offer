package LeetCode;

// 两数相加

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode pNode = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int m = p == null ? 0 : p.val;
            int n = q == null ? 0 : q.val;
            int sum = m + n + carry;
            carry = sum / 10;
            pNode.next = new ListNode(sum % 10);
            pNode = pNode.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0)
            pNode.next = new ListNode(carry);
        return dummyHead.next;
    }
}
