package jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return null;
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.remove();
            res.add(treeNode.val);
            if (treeNode.left != null) queue.add(treeNode.left);
            if (treeNode.right != null) queue.add(treeNode.right);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
