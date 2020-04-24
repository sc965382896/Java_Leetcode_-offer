package LeetCode;

// 后序遍历
// 递归法、转置法、非递归法

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    // 递归法
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversalCore(res, root);
        return res;
    }
    public void postorderTraversalCore(List<Integer> res, TreeNode root) {
        if (root == null)
            return;
        postorderTraversalCore(res, root.left);
        postorderTraversalCore(res, root.right);
        res.add(root.val);
    }
    // 转置法
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.empty()) {
            while (treeNode != null) {
                res.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.right;
            }
            if (!stack.empty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            ans.add(res.get(i));
        }
        return res;
    }
    // 非递归法
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        TreeNode lastTreenode = null;
        while (treeNode != null || !stack.empty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.empty()) {
                treeNode = stack.pop();
                if (treeNode.right == null || treeNode.right == lastTreenode) {
                    res.add(treeNode.val);
                    lastTreenode = treeNode;
                    treeNode = null;
                } else {
                    stack.push(treeNode);
                    treeNode = treeNode.right;
                }
            }
        }
        return res;
    }
}
