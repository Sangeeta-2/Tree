/*
Inorder->Left->Root->Right
TC->O(N)//n->no.of nodes
SC->O(H)//H->Height of the tree
 */
public class InorderTraversalRecursion {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);
        InorderTraversalRecursion it = new InorderTraversalRecursion();
        it.inorderTraversalRecursion(root);

    }

    private void inorderTraversalRecursion(TreeNode node) {
        if(node==null){
            return;
        }
        inorderTraversalRecursion(node.left);
        System.out.print(node.val+" ");//Root means print
        inorderTraversalRecursion(node.right);
    }
}
