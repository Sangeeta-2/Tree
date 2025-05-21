import java.util.ArrayList;
import java.util.Stack;

/*
Inorder traversal means Left->Root->Right
TC->O(N)//n->no.of nodes
SC->O(H)//H->Height of the tree
 */
public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> inorder=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while(true){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                else{
                    node=stack.pop();
                    inorder.add(node.val);
                    node=node.right;
                }
            }
        }
        return inorder;
    }
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
        InorderTraversal it=new InorderTraversal();
        ArrayList<Integer> inorder=it.inorderTraversal(root);
        for(int i=0;i<inorder.size();i++){
            System.out.print(inorder.get(i)+" ");
        }
    }
}
