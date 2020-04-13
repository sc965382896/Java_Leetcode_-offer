package jianzhiOffer;

import java.util.ArrayList;
import java.util.Stack;

// 面试题6：从尾到头打印链表

public class Solution6 {
    class ListNode {
        public int val;
        public ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    // 循环的方法
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null)
            return result;
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }

    // 递归的方法
    public ArrayList<Integer> printListFromTailToHeadRecursively(ListNode listNode) {
        ArrayList<Integer> al = new ArrayList<>();
        if (listNode != null ) {
            returnListNodeVal(listNode, al);
        }
        return al;
    }
    public void returnListNodeVal(ListNode ln, ArrayList<Integer> al) {
        if (ln.next != null) {
            returnListNodeVal(ln.next, al);
        }
        al.add(ln.val);
    }
}
