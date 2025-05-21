/*
TC->O(N)
SC->O(N)
 */
public class LCABinaryTree {
    public TreeNode findLCA(TreeNode root,TreeNode p,TreeNode q){
        if(root==null || root.val==p.val || root.val==q.val){
            return root;
        }
        TreeNode leftNode=findLCA(root.left,p,q);
        TreeNode rightNode=findLCA(root.right,p,q);
        if(leftNode==null){
            return rightNode;
        }
        else if(rightNode==null){
            return leftNode;
        }
        else{
            return root;
        }
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.right.left=new TreeNode(6);
        root.left.right.right=new TreeNode(7);
        root.right.left=new TreeNode(8);
        root.right.right=new TreeNode(9);
        TreeNode p=new TreeNode(4);
        TreeNode q=new TreeNode(7);
        LCABinaryTree lcaBinaryTree=new LCABinaryTree();
        TreeNode lca=lcaBinaryTree.findLCA(root,p,q);
        System.out.println("The Lowest Common Ancestor(LCA) of the Binary Tree is "+lca.val);
    }
}
