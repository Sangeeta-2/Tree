import java.util.ArrayList;

/*
Inorder of any BST is sorted.
But if we try to do in iterative or in Recursiveway, it takes TC->O(N) and SC-O(N)
But using Morris Traversal we can do it in TC->O(N) and SC->O(1)
 */
public class KthSmallestElementBST {
    public ArrayList<Integer> inorderMorrisTraversal(TreeNode root){
        ArrayList<Integer> inorder=new ArrayList<>();
        if(root==null){
            return inorder;
        }
        TreeNode currentNode=root;
        while(currentNode!=null){
            if(currentNode.left==null){
                inorder.add(currentNode.val);
                currentNode=currentNode.right;
            }
            else{
                TreeNode temp=currentNode.left;
                while(temp.right!=null&&temp.right!=currentNode){
                    temp=temp.right;
                }
                if(temp.right==null){// Here according to Morris Traversal we are connecting left child's rightmost node with parent node
                    temp.right=currentNode;
                    currentNode=currentNode.left;
                }else{// WE are restoring the tree back by deleting the connection earlier formed
                    temp.right=null;
                    inorder.add(currentNode.val);
                    currentNode=currentNode.right;
                }
            }
        }
        return inorder;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(4);
        root.left.left.right=new TreeNode(2);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(8);
        KthSmallestElementBST kthSmallestElementBST=new KthSmallestElementBST();
        int k=4;
        ArrayList<Integer> inorderTraversal=kthSmallestElementBST.inorderMorrisTraversal(root);
        int element=inorderTraversal.get(k-1);//0-based indexing
        System.out.println("The "+k+"th smallest element in the tree is "+element);
        //Kth largest element
        int kthLargestElement=inorderTraversal.get(inorderTraversal.size()-k);
        System.out.print("The "+k+"th largest element in the tree is "+kthLargestElement);
    }

}
