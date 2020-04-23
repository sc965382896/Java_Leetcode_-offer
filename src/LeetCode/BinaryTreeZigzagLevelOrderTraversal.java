package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 二叉树的锯齿形层次遍历
// 广度优先遍历+两个栈轮流保存每一层的节点。使用栈的原因是输出的顺序是Z字形。

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
