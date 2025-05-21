import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversalTwoStack {
    public ArrayList<Integer> postOrderTraveralTwoStacks(TreeNode root){
        Stack<TreeNode> st1=new Stack<>();
        Stack<TreeNode>st2=new Stack<>();
        ArrayList<Integer> postorder=new ArrayList<>();
        if(root==null){
            return postorder;
        }
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode node=st1.peek();
            st1.pop();
            st2.push(node);
            if(node.left!=null){
                st1.push(node.left);
            }
            if(node.right!=null){
                st1.push(node.right);
            }
        }
        while(!st2.isEmpty()){
            postorder.add(st2.peek().val);
            st2.pop();
        }
        return postorder;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.left.right=new TreeNode(7);
        root.right.left.right.right=new TreeNode(8);
        PostOrderTraversalTwoStack obj=new PostOrderTraversalTwoStack();
        ArrayList<Integer> postorder=obj.postOrderTraveralTwoStacks(root);
        for(Integer it:postorder){
            System.out.print(it);
        }
    }
}
