import java.util.HashMap;
import java.util.Map;

/*
Construct Binary tree from given inorder and preorder traversal
inorder={40,20,50,10,60,30}--->L->Root->R
preorder={10,20,40,50,30,60}-->Root->L->R
 */
public class ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder,int[]inorder){
        Map<Integer,Integer>inMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        TreeNode root=buildTree(preorder,0,preorder.length-1, inorder,0,inorder.length-1,inMap);
        return root;
    }
    public TreeNode buildTree(int[] preorder,int preStart,int preEnd,int[]inorder,int inStart,int inEnd,Map<Integer,Integer> inMap){
        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode parent=new TreeNode(preorder[preStart]);
        int inRoot=inMap.get(parent.val);
        int nums_left=inRoot-inStart;
        parent.left=buildTree(preorder,preStart+1,preStart+nums_left,inorder,inStart,inRoot+1,inMap);
        parent.right=buildTree(preorder,preStart+nums_left+1,preEnd,inorder,inRoot+1,inEnd,inMap);
        return parent;
    }
    public static void main(String[] args){
        int[] inorder={40,20,50,10,60,30};
        int[] preorder={10,20,40,50,30,60};
        ConstructBinaryTree constructBinaryTree=new ConstructBinaryTree();
        TreeNode root=constructBinaryTree.buildTree(preorder,inorder);
        System.out.println(root.val);
    }
}
