package dkc.leetcode.judst_is_subtree_07_24;

import dkc.leetcode.TreeNode;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * User:Mr.Du
 * Date:2019/7/24
 * Time:23:03
 */
public class Main {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){return false;}
        return isSame(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }
    public boolean isSame(TreeNode root1,TreeNode root2) {
        if(root2 == null){return true;}
        if(root1 == null){return false;}
        if(root1.val == root2.val){
            return isSame(root1.left,root2.left) && isSame(root1.right,root2.right);
        }else{
            return false;
        }
    }
}
