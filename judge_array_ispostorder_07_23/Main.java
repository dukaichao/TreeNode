package dkc.leetcode.judge_array_ispostorder_07_23;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 *
 * User:Mr.Du
 * Date:2019/7/23
 * Time:19:50
 */
public class Main {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return getB(sequence,0,sequence.length-1);
    }

    public static boolean getB(int[] arr,int start,int end){
        if(start>=end) return true;
        int index = find(arr,arr[end],start,end-1);
        if(index == -1) return true;
        for(int i = index;i<end;i++){
            if(arr[i]<arr[end]) return false;
        }
        return getB(arr,start,index-1)&&getB(arr,index,end-1);
    }

    public static int find(int[] arr,int value,int start,int end){
        for(int i = start;i<=end;i++){
            if(arr[i]>value){
                return i;
            }
        }
        return -1;
    }
}
