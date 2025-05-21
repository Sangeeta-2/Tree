public class InorderPredecessorBST {
    public TreeNode inorderSuccessorBST(TreeNode root,TreeNode node){
        TreeNode predecessor=null;
        if(root==null){
            return predecessor;
        }
        while(root!=null){
            if(node.val>root.val){
                predecessor=root;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return predecessor;
    }
    public static void main(String[] args){
        TreeNode node=new TreeNode(8);
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.left.left.left=new TreeNode(1);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(9);
        root.right.right.left=new TreeNode(8);
        root.right.right.right=new TreeNode(10);
        InorderPredecessorBST inorderPredecessorBST=new InorderPredecessorBST();
        TreeNode predecessor=inorderPredecessorBST.inorderSuccessorBST(root,node);
        System.out.print("Inorder Predecessor of "+node.val+" is "+predecessor.val);
    }
}
