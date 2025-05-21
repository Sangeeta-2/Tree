import java.util.ArrayList;
import java.util.Stack;

/*
Postorder traversal means Left->Right->Root
TC->O(N)//n->no.of nodes
SC->O(H)//H->Height of the tree
 */
public class PostOrderTraversalOneStack {
    public ArrayList<Integer> postOrderUsingOneStack(TreeNode root){
        if(root==null){
            return new ArrayList<>();
        }
        ArrayList<Integer> postorder=new ArrayList<>();
        TreeNode curr=root;
        Stack<TreeNode> st=new Stack<>();
        while(curr!=null || !st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            else{
                TreeNode temp=st.peek().right;
                if(temp==null){
                    temp=st.peek();
                    st.pop();
                    postorder.add(temp.val);
                    while(!st.isEmpty() && temp==st.peek().right){
                        temp=st.peek();
                        st.pop();
                        postorder.add(temp.val);
                    }
                }
                else{
                    curr=temp;
                }
            }
        }
        return postorder;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(3);
        root.left.left.right=new TreeNode(4);
        root.left.left.right.right=new TreeNode(5);
        root.left.left.right.right.right=new TreeNode(6);
        root.right.left=new TreeNode(8);
        root.right.right=new TreeNode(9);
        root.right.right.right=new TreeNode(10);
        PostOrderTraversalOneStack obj=new PostOrderTraversalOneStack();
        ArrayList<Integer> postorder=obj.postOrderUsingOneStack(root);
        for(int i=0;i<postorder.size();i++){
            System.out.print(postorder.get(i)+" ");
        }
    }
}
