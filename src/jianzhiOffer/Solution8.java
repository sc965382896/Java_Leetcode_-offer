package jianzhiOffer;

// 面试题8：二叉树的下一个节点

public class Solution8 {
    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        public TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            return pRight;
        } else {
            TreeLinkNode pParent = pNode.next;
            while (pParent != null) {
                if (pParent.left == pNode) {
                    return pParent;
                }
                pNode = pParent;
                pParent = pParent.next;
            }
            return null;
        }
    }
}
