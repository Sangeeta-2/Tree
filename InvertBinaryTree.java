import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    //Recursion Approach
    public TreeNode invertRecursively(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode left=invertRecursively(root.left);
        TreeNode right=invertRecursively(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
    //Iterative Approach
    public TreeNode invertIteratively(TreeNode root){
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode currentNode=queue.poll();
            //Swapping
            TreeNode temp=currentNode.right;
            currentNode.right=currentNode.left;
            currentNode.left=temp;
            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }
        }
        return root;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(1);
        root.right=new TreeNode(3);
        InvertBinaryTree invertBinaryTree=new InvertBinaryTree();
        TreeNode node=invertBinaryTree.invertRecursively(root);
        levelOrderTraversal lot=new levelOrderTraversal();
        ArrayList<ArrayList<Integer>> array=lot.levelOrder(node);
        for(ArrayList<Integer> it:array){
            System.out.println(it+" ");
        }
        System.out.println();
        TreeNode node1=invertBinaryTree.invertIteratively(root);
        ArrayList<ArrayList<Integer>> array1=lot.levelOrder(node);
        for(ArrayList<Integer> it:array){
            System.out.println(it+" ");
        }
    }
}
