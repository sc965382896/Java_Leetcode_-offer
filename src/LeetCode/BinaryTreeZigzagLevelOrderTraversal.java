package LeetCode;

import java.util.*;

// 二叉树的锯齿形层次遍历
// 广度优先遍历+两个栈轮流保存每一层的节点。使用栈的原因是输出的顺序是Z字形。

public class BinaryTreeZigzagLevelOrderTraversal {
    // 双端队列，通过标志位决定遍历的方向，通过双端队列+每层节点数模拟两个栈完成左右交替遍历。
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        boolean leftToRight = true;
        int n = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            n = deque.size();
            List<Integer> temp = new ArrayList<>();
            if (leftToRight) {
                while (n > 0) {
                    TreeNode treeNode = deque.removeLast();
                    temp.add(treeNode.val);
                    if (treeNode.left != null) deque.addFirst(treeNode.left);
                    if (treeNode.right != null) deque.addFirst(treeNode.right);
                    --n;
                }
            } else {
                while (n > 0) {
                    TreeNode treeNode = deque.removeFirst();
                    temp.add(treeNode.val);
                    if (treeNode.right != null) deque.addLast(treeNode.right);
                    if (treeNode.left != null) deque.addLast(treeNode.left);
                    --n;
                }
            }
            res.add(temp);
            leftToRight = !leftToRight;
        }
        return res;
    }
    // 两个栈交替使用。
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        int order = 0;
        s1.push(root);
        while (!s1.empty() || !s2.empty()) {
            List<Integer> temp = new ArrayList<>();
            if (order == 0) {
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    temp.add(node.val);
                    if (node.left != null) s2.push(node.left);
                    if (node.right != null) s2.push(node.right);
                }
                res.add(temp);
                order = 1;
            } else {
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    temp.add(node.val);
                    if (node.right != null) s1.push(node.right);
                    if (node.left != null) s1.push(node.left);
                }
                res.add(temp);
                order = 0;
            }
        }
        return res;
    }
}
