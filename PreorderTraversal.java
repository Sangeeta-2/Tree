import java.util.ArrayList;
import java.util.Stack;

/*
Preorder-> Root->Left->Right
TC->O(N)//n->no.of nodes
SC->O(H)//H->Height of the tree
 */
public class PreorderTraversal {
    public ArrayList<Integer> preOrderTraveral(TreeNode root){
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> preorder=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            preorder.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return preorder;
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
        PreorderTraversal pt=new PreorderTraversal();
        ArrayList<Integer> preorder=pt.preOrderTraveral(root);
        for(int i=0;i<preorder.size();i++){
            System.out.print(preorder.get(i)+" ");
        }
    }
}
