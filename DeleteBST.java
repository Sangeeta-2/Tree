import java.util.ArrayList;

/*
TC->O(logN)
 */
public class DeleteBST {
    public TreeNode deleteNodeBST(TreeNode root,int value){
        if(root==null){
            return null;
        }
        if(root.val==value){
          return helper(root);
        }
        TreeNode dummy=root;
        while(root!=null){
            if(root.val>value){
                if(root.left!=null && root.left.val==value){
                    root.left=helper(root.left);
                    break;
                }else{
                    root=root.left;
                }
            }else{
                if(root.right!=null && root.right.val==value){
                    root.right=helper(root.right);
                    break;
                }else{
                    root=root.right;
                }
            }
        }
        return dummy;
    }

    private TreeNode helper(TreeNode node) {
        TreeNode rightChild=node.right;
        TreeNode lastRightChild=findLastRight(node.left);
        lastRightChild.right=rightChild;
        return node.left;
    }

    private TreeNode findLastRight(TreeNode node) {
        if(node.right==null){
            return node;
        }
        else{
            return findLastRight(node.right);
        }
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(6);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(7);
        int key=3;
        DeleteBST deleteBST=new DeleteBST();
        TreeNode node=deleteBST.deleteNodeBST(root,key);
        //Print the tree inorder,preorder, level order any order
        levelOrderTraversal lot=new levelOrderTraversal();
        ArrayList<ArrayList<Integer>> result=lot.levelOrder(node);
        for(ArrayList<Integer> level:result){
            System.out.print(level);
        }
    }
}
