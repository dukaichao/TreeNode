package dkc.pratice;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-03
 * Time:10:38
 */

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        TreeNode node = Method.createBinaryTree(list);
        System.out.println("前序遍历：");
        Method.preOrderTraveral(node);
        System.out.println();
        System.out.println("前序遍历：");
        Method.preOrderTraveralWithStack(node);
        System.out.println();
        System.out.println("中序遍历：");
        Method.inOrderTraveral(node);
        System.out.println();
        System.out.println("中序遍历：");
        Method.inOrderTraveralWithStack(node);
        System.out.println();
        System.out.println("后序遍历：");
        Method.postOrderTraveral(node);
        System.out.println();
        System.out.println("后序遍历：");
        Method.postOrderTraveralWithStack(node);
        System.out.println();
    }
}
