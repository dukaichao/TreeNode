package dkc.binarytree.isValidBST;

import java.util.Stack;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019/7/18
 * Time:23:36
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class Main {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long tmp = Long.MIN_VALUE;
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                if(root.val<=tmp){
                    return false;
                }
                tmp = root.val * 1L;

                root = root.right;
            }
        }
        return true;
    }
}
