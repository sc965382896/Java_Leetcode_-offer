package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 二叉树的中序遍历
// 递归法、非递归法

public class BinaryTreeInorderTraversal {
    // 递归法
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        return res;
    }
    public void inorderTraversalCore(List<Integer> res, TreeNode root) {
        if (root == null)
            return;
        inorderTraversalCore(res, root.left);
        res.add(root.val);
        inorderTraversalCore(res, root.right);
    }

        // 非递归法
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.empty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.empty()) {
                treeNode = stack.pop();
                res.add(treeNode.val);
                treeNode = treeNode.right;
            }
        }
        return res;
    }
}
