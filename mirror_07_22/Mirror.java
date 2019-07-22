package dkc.leetcode.mirror_07_22;

import dkc.leetcode.TreeNode;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 *
 *
 * User:Mr.Du
 * Date:2019/7/22
 * Time:17:37
 */
public class Mirror {

    public void mirror(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirror(root.left);
        mirror(root.right);
    }
}
