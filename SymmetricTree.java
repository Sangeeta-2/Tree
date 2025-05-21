import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }
        Queue<TreeNode> leftTree=new LinkedList<>();
        Queue<TreeNode> rightTree=new LinkedList<>();
        leftTree.add(root.left);
        rightTree.add(root.right);
        while(!leftTree.isEmpty() && !rightTree.isEmpty()){
           TreeNode leftNode=leftTree.poll();
           TreeNode rightNode=rightTree.poll();
           if(leftNode==null && rightNode==null){
               continue;
           }
           if(leftNode==null || rightNode==null){
               return false;
           }
           if(leftNode.val!=rightNode.val){
               return false;
           }
           leftTree.add(leftNode.left);
           leftTree.add(leftNode.right);
           //Reverse order adding as they are mirror to each other
           rightTree.add(rightNode.right);
           rightTree.add(rightNode.left);
        }
        return true;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(3);
//        root.right.left=new TreeNode(3);
//        root.right.right=new TreeNode(4);
        SymmetricTree symmetricTree=new SymmetricTree();
        if(symmetricTree.isSymmetric(root)){
            System.out.println("Yes the Binary Tree is Symmetric around its centre");
        }
        else{
            System.out.println("No the Binary Tree is not Symmetric around its centre");
        }
    }
}
