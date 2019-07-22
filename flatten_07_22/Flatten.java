package dkc.leetcode.flatten_07_22;

import dkc.leetcode.TreeNode;

import java.util.Scanner;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * User:Mr.Du
 * Date:2019/7/22
 * Time:14:54
 */
public class Flatten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String ss = sc.nextLine();
            char[] chars = ss.toCharArray();
            for(int i = 0;i<chars.length;i++){
                if(!Character.isUpperCase(chars[i]) && !Character.isLowerCase(chars[i]))
                    chars[i] = ' ';
            }
            ss = new String(chars);
            String[] s = ss.split(" ");
            if(s.length == 0) { return; }
            for(int i = s.length-1;i>=0;i--){
                if(i == 0){
                    System.out.println(s[i]);
                }else if(!s[i].equals("")){
                    System.out.print(s[i]+" ");
                }
            }
        }
    }
    TreeNode pre = null;
    TreeNode curr = null;
    public void flatten(TreeNode root) {
        if(root != null){
            curr = root;
            if(pre != null){
                pre.right = curr;
                pre.left = null;
                pre = curr;
            }else{
                pre = curr;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            flatten(left);
            flatten(right);
        }
    }
}
