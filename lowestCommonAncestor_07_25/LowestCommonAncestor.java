package dkc.leetcode.lowestCommonAncestor_07_25;


import dkc.leetcode.TreeNode;

import java.util.*;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019/7/25
 * Time:8:35
 */
public class LowestCommonAncestor {

    private int i = 0;
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(new Integer[]{1,2,4,6,null,null,null,5,null,null,3}));
        TreeNode root = createBinaryTree(list);
        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(6);
        System.out.println(getLCA(root,p,q).val);
        System.out.println(lowestCommonAncestor(root,p,q).val);
    }

    //创建二叉树
    public static TreeNode createBinaryTree(LinkedList<Integer> list){
        TreeNode node = null;
        if(list == null || list.isEmpty()){
            return null;
        }
        Integer data = list.removeFirst();
        if(data!=null){
            node = new TreeNode(data);
            node.left = createBinaryTree(list);
            node.right = createBinaryTree(list);
        }
        return node;
    }

    //递归获取最近祖先结点
    public static TreeNode getLCA(TreeNode root,TreeNode p,TreeNode q){
        if(root == null || p.val == root.val || q.val == root.val) return root;
        TreeNode left = getLCA(root.left,p,q);
        TreeNode right = getLCA(root.right,p,q);
        return left == null ? right : (right == null) ? left : root;
    }

    //迭代获取最近最先结点
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 作用就是层序遍历
        Deque<TreeNode> stack = new ArrayDeque<>();

        // 定义map，存放儿子结点和父亲节点，儿子结点的值作为key，父亲节点作为value
        Map<Integer, TreeNode> parent = new HashMap<>();

        parent.put(root.val, null);
        stack.push(root);

        // 利用层序遍历知道查找到p,q结点
        while ((!parent.containsKey(p.val) || !parent.containsKey(q.val)) ) {

            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left.val, node);
                stack.push(node.left);  //56
            }
            if (node.right != null) {
                parent.put(node.right.val, node);
                stack.push(node.right);
            }
        }

        // 定义存放q结点的祖先结点的集合.
        Set<Integer> ancestors = new HashSet<>();

        // 将p的祖先节点全部加入到set集合中
        while (p != null) {
            ancestors.add(p.val);//4,2,1
            p = parent.get(p.val);//2,1
        }

        // 找到set集合中包含q节点的结点，
        while (!ancestors.contains(q.val))
            q = parent.get(q.val);//4
        //找到q直接返回
        return q;

    }
}
