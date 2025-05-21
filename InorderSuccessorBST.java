public class InorderSuccessorBST {
    public TreeNode inorderSuccessorBST(TreeNode root,TreeNode node){
        TreeNode successor=null;
        if(root==null){
            return successor;
        }
        while(root!=null){
            if(node.val>=root.val){
                root=root.right;
            }else{
                successor=root;
                root=root.left;
            }
        }
        return successor;
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
        InorderSuccessorBST inorderSuccessorBST=new InorderSuccessorBST();
        TreeNode successor=inorderSuccessorBST.inorderSuccessorBST(root,node);
        System.out.print("Inorder Successor of "+node.val+" is "+successor.val);
    }

}
