/*
TC->O(logN)
 */
public class InsertBST {
    public void insert(TreeNode root,int value){
        TreeNode current_node=root;
        while(true){
            if(current_node.val>value){
                if(current_node.left!=null){
                    current_node=current_node.left;
                }
                else{
                  TreeNode newNode=new TreeNode(value);
                  current_node.left=newNode;
                  System.out.print("Inserting "+value+" in the left node of "+current_node.val);
                  break;
                }
            }else{
                if(current_node.right!=null){
                    current_node=current_node.right;
                }else{
                    TreeNode newNode=new TreeNode(value);
                    current_node.right=newNode;
                    System.out.print("Inserting "+value+" in the right node of "+current_node.val);
                    break;
                }
            }
        }
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        int value_to_insert=5;
        InsertBST insertBST=new InsertBST();
        insertBST.insert(root,value_to_insert);
        //Print the tree inorder,preorder, level order any order
    }
}
