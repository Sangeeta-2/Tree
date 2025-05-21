/*
TC->O(N)
SC->O(1)
 */
public class validBST {
    public boolean isValidBST(TreeNode root){
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long minVal,long maxVal){
        if(root==null){
            return true;
        }
        if(root.val>=maxVal || root.val<=minVal){
            return false;
        }
        return (isValidBST(root.left,minVal,root.val) && isValidBST(root.right,root.val,maxVal));
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(13);
        root.left=new TreeNode(10);
        root.right=new TreeNode(15);
        root.left.left=new TreeNode(7);
        root.left.right=new TreeNode(12);
        root.right.left=new TreeNode(14);
        root.right.right=new TreeNode(17);
        root.left.left.right=new TreeNode(9);
        root.left.left.right.left=new TreeNode(8);
        root.right.right.left=new TreeNode(16);
//        TreeNode root=new TreeNode(1);
//        root.left=new TreeNode(2);
//        root.right=new TreeNode(3);
//        root.left.left=new TreeNode(4);
//        root.left.right=new TreeNode(5);
//        root.right.left=new TreeNode(6);
//        root.right.right=new TreeNode(7);
        validBST validBST=new validBST();
        if(validBST.isValidBST(root)){
            System.out.print("Its a valid BST");
        }else{
            System.out.print("Its not a valid BST");
        }
    }
}
