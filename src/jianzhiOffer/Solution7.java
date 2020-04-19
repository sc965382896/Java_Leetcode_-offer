package jianzhiOffer;

import java.util.HashMap;

// 面试题7：重建二叉树
// 采用递归的方法

public class Solution7 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length <= 0 ||pre.length != in.length)
            return null;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i <in.length; i++) {
            hashMap.put(in[i], i);
        }
        return reConstructBinaryTreeCore(pre, in, 0, pre.length - 1, 0, in.length - 1, hashMap);
    }
    public TreeNode reConstructBinaryTreeCore(int[] pre, int[] in, int preL, int preR, int inL, int inR, HashMap<Integer, Integer> hashMap) {
        if (preL > preR)
            return null;
        int val = pre[preL];
        int index = hashMap.get(val);
        int leftLength = index - inL;
        int RightLength = inR - index;
        TreeNode pNode = new TreeNode(val);
        pNode.left = reConstructBinaryTreeCore(pre, in, preL + 1, preL + leftLength, inL, index - 1, hashMap);
        pNode.right = reConstructBinaryTreeCore(pre, in, preL + leftLength + 1, preR, index + 1, inR, hashMap);
        return pNode;
    }
}
