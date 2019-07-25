package dkc.leetcode.tree2str_07_25;

import dkc.leetcode.TreeNode;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 *
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * 输出: "1(2()(4))(3)"
 *
 * User:Mr.Du
 * Date:2019/7/25
 * Time:1:11
 */
public class Main {

    StringBuilder sb = new StringBuilder();
    TreeNode pre = null;
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        helper(t, pre);
        return sb.substring(1, sb.length() - 1);
    }

    private void helper(TreeNode root, TreeNode pre) {
        if (root == null) return;
        //前序遍历
        //1.如果当前节点为父节点的右子树且左子树为空，括号不能省略
        if (pre != null && pre.left == null && pre.right == root) {
            sb.append("()");
        }
        sb.append("(").append(root.val);
        pre = root;
        helper(root.left, pre);
        helper(root.right, pre);
        //遍历完当前节点后关闭括号
        sb.append(")");
    }
}
