/*
Binary Tree Maximum Path sum.
Path does not need to go through root.
Formula -> node.val+left value+right value
TC->O(N)
 */
public class MaximumPathSum {
    static int max=Integer.MIN_VALUE;
    public int getMaximumPath(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftValue=getMaximumPath(root.left);
        int rightValue=getMaximumPath(root.right);
        max=Math.max(max,leftValue+rightValue+root.val);
        return Math.max(leftValue,rightValue)+root.val;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(-10);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        MaximumPathSum maximumPathSum=new MaximumPathSum();
        maximumPathSum.getMaximumPath(root);
        System.out.println("The maximum path sum is "+MaximumPathSum.max);
    }
}
