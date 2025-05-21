import java.util.ArrayList;

/*
Convert sorted array to BST
 */
public class SortedArrayToBST {
    public TreeNode convertArrayToBST(int[] array,int startIndex,int endIndex){
        if(array.length==0){
            return null;
        }
        if(startIndex>endIndex) return null;
        int middleIndex=(startIndex+endIndex)/2;
        TreeNode node=new TreeNode(array[middleIndex]);
        TreeNode left=convertArrayToBST(array,startIndex,middleIndex-1);
        TreeNode right=convertArrayToBST(array,middleIndex+1,endIndex);
        node.left=left;
        node.right=right;

        return node;
    }
    public static void main(String[] args){
        int[] array = {-10, -3, 0, 5, 9};
        SortedArrayToBST sortedArrayToBST=new SortedArrayToBST();
        TreeNode root=sortedArrayToBST.convertArrayToBST(array,0,array.length -1);
        System.out.print("The root of the tree is now is "+root.val);

    }
}
