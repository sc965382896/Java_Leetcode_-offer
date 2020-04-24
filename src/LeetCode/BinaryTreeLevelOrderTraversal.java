package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二叉树的层序遍历
// BFS+双层循环，外层改变遍历的层，内层遍历该层节点。

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            n = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (n-- > 0) {
                TreeNode treeNode = queue.remove();
                temp.add(treeNode.val);
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
            res.add(temp);
        }
        return res;
    }
}
