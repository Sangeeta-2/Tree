/*
TC->O(N)
SC->O(N)
formula -> 1+Max(left height,right height)
Height is also considered as depth of the binary tree
 */
public class HeightOfBinaryTree {
    public int heightOfBinaryTree(TreeNode root){
        if(root==null){
            return 0;
        }
        int left_height=heightOfBinaryTree(root.left);
        int right_height=heightOfBinaryTree(root.right);
        return 1+Math.max(left_height,right_height);
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(6);
        root.right.left.left=new TreeNode(5);
        HeightOfBinaryTree depthOfBinaryTree= new HeightOfBinaryTree();
        System.out.println("The height of the binary tree is "+depthOfBinaryTree.heightOfBinaryTree(root));
    }
}
