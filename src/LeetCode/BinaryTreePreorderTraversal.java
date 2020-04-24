package LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 二叉树的前序遍历
// 递归法、非递归法

public class BinaryTreePreorderTraversal {
    // 递归法
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversalCore(res, root);
        return res;
    }
    public void preorderTraversalCore(List<Integer> res, TreeNode root) {
        if (root == null)
            return;
        res.add(root.val);
        preorderTraversalCore(res, root.left);
        preorderTraversalCore(res, root.right);
    }

    // 非递归法
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (root != null || !stack.empty()) {
            while (treeNode != null) {
                res.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.empty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
        return res;
    }
}
