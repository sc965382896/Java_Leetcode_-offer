package LeetCode;

import java.util.ArrayList;
import java.util.List;

// 二叉树的最近公共祖先
//
public class LowestCommonAncestorOfABinaryTree {
    int index = 0;
    ArrayList<ArrayList<TreeNode>> res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = new ArrayList<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        find(list, root, p, q);
        List<TreeNode> list1 = res.get(0);
        List<TreeNode> list2 = res.get(1);
        TreeNode pre = null;
        for (int i = 0; i < list1.size() && i < list2.size(); i++) {
            if (list1.get(i) != list2.get(i))
                break;
            pre = list1.get(i);
        }
        return pre;
    }
    public void find(ArrayList<TreeNode> list, TreeNode root, TreeNode p, TreeNode q) {
        if (index > 1 || root == null)
            return;
        list.add(root);
        if (root == p) {
            res.add(new ArrayList<>(list));
            ++index;
        } else if (root == q) {
            res.add(new ArrayList<>(list));
            ++index;
        }
        find(list, root.left, p, q);
        find(list, root.right, p, q);
        list.remove(list.size() - 1);
    }
}
