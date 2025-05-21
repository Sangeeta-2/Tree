/*
For Recursive and Iterative the time and space complexity is
TC->O(N) and SC->O(N)
For Morris
TC->O(N)
SC->O(1)
 */
import java.util.Stack;

public class FlattenBinaryTree {
    //Recursive approach
    static TreeNode prev=null;
    public TreeNode flattenTreeRecursively(TreeNode root){
        if(root==null) return null;
        flattenTreeRecursively(root.right);
        flattenTreeRecursively(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
        return root;
    }
    //Iterative approach
    public TreeNode flattenTreeIteratively(TreeNode root){
        if(root==null) return null;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.peek();
            stack.pop();
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
            if(!stack.isEmpty()){
            node.right=stack.peek();
            node.left=null;
            }
        }
        return root;
    }
    //Morris Algo -->where we are pointing node's left child's rightmost child to node's right
    public TreeNode flattenTreeMorrisAlgo(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode temp=curr.left;
                while(temp.right!=null){
                    temp=temp.right;
                }
                temp.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;
        }
        return root;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(5);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(6);
        root.right.right.left=new TreeNode(7);
        FlattenBinaryTree fbt=new FlattenBinaryTree();

        // Create copies of the tree for each algorithm
        TreeNode rootForRecursive = copyTree(root);
        TreeNode rootForIterative = copyTree(root);
        TreeNode rootForMorris = copyTree(root);

        // Apply each algorithm on its own copy
        TreeNode rNode=fbt.flattenTreeRecursively(rootForRecursive);
        System.out.print("Recursive result: ");
        while(rNode!=null){
            System.out.print(rNode.val+"->");
            rNode=rNode.right;
        }
        System.out.println("null");

        TreeNode iNode=fbt.flattenTreeIteratively(rootForIterative);
        System.out.print("Iterative result: ");
        while(iNode!=null){
            System.out.print(iNode.val+"->");
            iNode=iNode.right;
        }
        System.out.println("null");

        TreeNode mNode=fbt.flattenTreeMorrisAlgo(rootForMorris);
        System.out.print("Morris result: ");
        while(mNode!=null){
            System.out.print(mNode.val+"->");
            mNode=mNode.right;
        }
        System.out.println("null");
    }

    // Helper method to create a deep copy of the tree
    private static TreeNode copyTree(TreeNode original) {
        if (original == null) return null;

        TreeNode copy = new TreeNode(original.val);
        copy.left = copyTree(original.left);
        copy.right = copyTree(original.right);

        return copy;
    }

}
