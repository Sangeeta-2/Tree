import java.util.ArrayList;

public class PreorderMorrisTraversal {
    public ArrayList<Integer> preorderMorrisTraversal(TreeNode root){
        ArrayList<Integer> preorder =new ArrayList<>();
        if(root==null){
            return preorder;
        }
        TreeNode currentNode=root;
        while(currentNode!=null){
            if(currentNode.left==null){
                preorder.add(currentNode.val);
                currentNode=currentNode.right;
            }
            else{
                TreeNode temp=currentNode.left;
                while(temp.right!=null&&temp.right!=currentNode){
                    temp=temp.right;
                }
                if(temp.right==null){
                    temp.right=currentNode;
                    preorder.add(currentNode.val);
                    currentNode=currentNode.left;
                }
                else{
                    temp.right=null;
                    currentNode=currentNode.right;
                }
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
        root.left.right.right=new TreeNode(6);
         PreorderMorrisTraversal preorderMorrisTraversal=new PreorderMorrisTraversal();
        ArrayList<Integer> preorderList=preorderMorrisTraversal.preorderMorrisTraversal(root);
        for(Integer element:preorderList){
            System.out.print(element);
        }
    }
}
