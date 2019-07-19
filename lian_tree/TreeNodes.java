package dkc.bit.orderbinarytree.lian_tree;



/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019/7/19
 * Time:16:36
 */
class TreeNode {
    public char c;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char c) {
        this.c = c;
    }

}
public class TreeNodes {

    public static int i;
    public static TreeNode createTree(String s){
        TreeNode root = null;
        if(s.charAt(i)!='#'){
            root = new TreeNode(s.charAt(i));
            i++;
            root.left = createTree(s);
            root.right = createTree(s);
        }else{
            i++;
        }
        return root;
    }

    public static void preOrder(TreeNode root){
        if(root == null) return;
        System.out.print(root.c+" ");
        preOrder(root.left);
        preOrder(root.right);
    }


    //结点个数
    public static int getSize(TreeNode root){
        if(root == null) return 0;
        return getSize(root.left)+getSize(root.right)+1;
    }


    //求高度
    public static int getLength(TreeNode root){
        if(root == null) return 0;

        int lh = getLength(root.left);
        int rh = getLength(root.right);

        return Math.max(lh,rh)+1;
    }

    //求叶子数
    public static int getLeafSize(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return getLeafSize(root.left)+getLeafSize(root.right);
    }

    //第k层结点数
    public static int getKLevelSize(TreeNode root,int k){
        if(root == null) return 0;
        if(k == 1) return 1;
        return getKLevelSize(root.left,k-1) + getKLevelSize(root.right,k-1);
    }










    public static void main(String[] args) {
        String s = "ABC##DE#G##F###";
        TreeNode root = createTree(s);
        preOrder(root);
        System.out.println();
        System.out.println(getSize(root));

        System.out.println(getLeafSize(root));

        System.out.println(getKLevelSize(root,2));
    }
    /*
                    A
                 B
              C     D
                  E    F
                    G
     */
}
