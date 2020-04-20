package LeetCode;

// 合并K个排序链表
// 1.暴力法，将所有节点保存(O(N))并排序(O(Nlog(N))，然后创建新链表(O(N))。2.第一个链表依次与之后的链表合并。
// 3.分治法。0 1合并，2 3合并，然后0 2合并，一直进行下去。

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        for (int i = 1; i < lists.length; i <<= 1) {
            int j = 0;
            while (j + i < lists.length) {
                lists[j] = mergeTwoLists(lists[j], lists[j + i]);
                j += i * 2;
            }
        }
        return lists[0];
    }
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode dummyHead = new ListNode(0);
        ListNode pNode = dummyHead;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                pNode.next = p1;
                p1 = p1.next;
                pNode = pNode.next;
            } else {
                pNode.next = p2;
                p2 = p2.next;
                pNode = pNode.next;
            }
        }
        if (p1 != null) {
            pNode.next = p1;
        }
        if (p2 != null) {
            pNode.next = p2;
        }
        return dummyHead.next;
    }
}
