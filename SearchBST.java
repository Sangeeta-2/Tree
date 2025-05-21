/*
BST-> The defining properties of a BST is its ordering property.
For any given node, all nodes in its left sub tree have values less than the node's value.
All the nodes in its right subtree have values greater than the node's value
Both left and right subtrees of any node are also BSTs
Search:-
TC->O(logN)
 */
public class SearchBST {
    public TreeNode search(TreeNode root,int value){
        TreeNode node=root;
        while(node!=null && node.val!=value){
            node=node.val>value?node.left:node.right;
        }
        return node;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        SearchBST searchBST = new SearchBST();
        int value=8;
        TreeNode result = searchBST.search(root, value);
        if (result != null) {
            System.out.print("Found " + value + " in the tree");
        } else {
            System.out.print("Not Found "+value+" in the tree");
        }
    }
}
