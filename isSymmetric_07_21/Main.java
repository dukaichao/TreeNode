package dkc.leetcode.isSymmetric_07_21;

import dkc.leetcode.TreeNode;

import java.util.*;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * User:Mr.Du
 * Date:2019/7/21
 * Time:21:38
 */
public class Main {
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return in(root.left,root.right);
    }


    //递归
    public static boolean in(TreeNode l1,TreeNode l2){
        if(l1 == null && l2 == null) return true;
        if(l1 == null || l2 == null) return false;
        return l1.val == l2.val && in(l1.left,l2.right) && in(l1.right,l2.left);
    }

    //迭代
    public static boolean isSymm(TreeNode root){
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    //栈实现(和堆一样)
    public static boolean is(TreeNode root){
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()){
            TreeNode l1 = stack.pop();   //右3
            TreeNode l2 = stack.pop();   //左3
            if(l1 == null && l2 == null) continue;
            if(l1 == null || l2 == null) return false;
            if(l1.val != l2.val) return false;
            stack.push(l2.left);  //4
            stack.push(l1.right); //null
            stack.push(l1.left);  //5
            stack.push(l2.right); //5
        }
        return true;
    }
}
