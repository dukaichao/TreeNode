package dkc.leetcode.buildTree_with_p_i_07_19;

import dkc.leetcode.TreeNode;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * User:Mr.Du
 * Date:2019/7/19
 * Time:16:51
 */
public class Solution {

    public int preIndex = 0;
    public int find(int[] inorder, int inbegin,int inend,int val){
        for(int i = inbegin;i<=inend;i++){
            if(inorder[i] == val) return i;
        }
        return -1;
    }
    public TreeNode buildTreeChild(int[] preorder, int[] inorder, int inbegin,int inend) {
        if(inbegin>inend) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        int index = find(inorder,inbegin,inend,preorder[preIndex]);
        if(index == -1) return null;
        preIndex++;
        root.left = buildTreeChild(preorder,inorder,inbegin,index-1);
        root.right = buildTreeChild(preorder,inorder,index+1,inend);
        return root;
    }



    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }
}
