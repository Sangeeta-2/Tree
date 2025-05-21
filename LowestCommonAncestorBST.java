/*
Find Lowest common Ancestor(LCA) of 2 given nodes in a BST
LCA->Find the intersection path from the buttom
TC->O(H)
SC->O(1)
 */
public class LowestCommonAncestorBST {
    public TreeNode findLowestCommonAncestorBST(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return null;
        }
        int currentNode_value= root.val;
        if(currentNode_value< p.val && currentNode_value< q.val){
            return findLowestCommonAncestorBST(root.right,p,q);
        }
        if(currentNode_value> p.val && currentNode_value> q.val){
            return findLowestCommonAncestorBST(root.left,p,q);
        }
        return root;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(4);
        root.right=new TreeNode(13);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(8);
        root.left.left.left=new TreeNode(1);
        root.left.left.left.right=new TreeNode(2);
        root.left.right.left=new TreeNode(6);
        root.left.right.right=new TreeNode(9);
        root.left.right.left.left=new TreeNode(5);
        root.left.right.left.right=new TreeNode(7);
        root.left.right.right=new TreeNode(9);
        root.right.left=new TreeNode(11);
        root.right.right=new TreeNode(15);
        LowestCommonAncestorBST lowestCommonAncestorBST=new LowestCommonAncestorBST();
        TreeNode p=new TreeNode(5);
        TreeNode q=new TreeNode(9);
        TreeNode lca=lowestCommonAncestorBST.findLowestCommonAncestorBST(root,p,q);
        System.out.println("The Lowest Common Ancestor(LCA) of the Binary Search Tree is "+lca.val);
    }

}
