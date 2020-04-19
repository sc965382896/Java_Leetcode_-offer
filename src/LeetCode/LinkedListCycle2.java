package LeetCode;

// 环形链表2：寻找环形的入口。
// 快慢指针判断是否有环，计算环的长度n，使用双指针，一个指针先走n步，然后两个指针同时走，直到相遇就是入口。
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode pNode = hasCycle(head);
        if (pNode == null)
            return null;
        int length = getCycleLength(pNode);
        return getCycleHead(head, length);
    }
    public ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null)
             return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow)
                return fast;
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }
    public int getCycleLength(ListNode head) {
        ListNode pNode = head.next;
        int count = 1;
        while (pNode != head) {
            count++;
            pNode = pNode.next;
        }
        return count;
    }
    public ListNode getCycleHead(ListNode head, int length) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < length; i++) {
            fast = fast.next;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
