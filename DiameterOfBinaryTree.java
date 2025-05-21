/*
Diameter of a binary tree is also considered as the longest path between any 2 nodes.
formula->lh+rh
You can use diameter variable as static or normal.
Here we are traversing through the entire height of the tree and getting the longest path.
TC->O(N)
SC->O(N)
 */
public class DiameterOfBinaryTree {
    int diameter;
    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=getHeight(root.left);
        int rh=getHeight(root.right);
        diameter=Math.max(diameter,lh+rh);
        return 1+Math.max(lh,rh);
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(7);
        root.right.left.left=new TreeNode(5);
        root.right.left.left.left=new TreeNode(6);
        root.right.right.right=new TreeNode(8);
        root.right.right.right.right=new TreeNode(9);
        DiameterOfBinaryTree diameterOfBinaryTree=new DiameterOfBinaryTree();
        diameterOfBinaryTree.getHeight(root);
        System.out.println("Diameter of the binary tree is "+diameterOfBinaryTree.diameter);

    }
}
