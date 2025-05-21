/*
Preorder-> Root->Left->Right
TC->O(N)//n->no.of nodes
SC->O(H)//H->Height of the tree
 */
public class PreOrderTraversalRecursion {
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.right.left=new TreeNode(6);
        root.right.left=new TreeNode(7);
        root.right.right=new TreeNode(8);
        root.right.right.left=new TreeNode(9);
        root.right.right.right=new TreeNode(10);
        PreOrderTraversalRecursion ptr=new PreOrderTraversalRecursion();
        ptr.preOrderTraveralRecursion(root);
    }

    private void preOrderTraveralRecursion(TreeNode node) {
        if(node==null){
            return;
        }
        System.out.print(node.val+" ");// Root means print
        preOrderTraveralRecursion(node.left);
        preOrderTraveralRecursion(node.right);
    }
}
