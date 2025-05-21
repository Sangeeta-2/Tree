/*
Tree is said to be balanced when left height-right height <=1
TC->O(N)
SC->O(N)
 */
public class BalancedBinaryTree {
    public boolean isBalancedTree(TreeNode root){
        return getHeight(root)!=-1;
    }

    private int getHeight(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        if(leftHeight == -1){
            return -1;
        }
        int rightHeight=getHeight(root.right);
        if(rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }
        return 1+Math.max(leftHeight,rightHeight);
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        //root.right.right.right=new TreeNode(13);
        BalancedBinaryTree balancedBinaryTree=new BalancedBinaryTree();
        if(balancedBinaryTree.isBalancedTree(root))
            System.out.println("The tree is balanced");
        else
            System.out.println("The tree is not balanced");
    }
}
