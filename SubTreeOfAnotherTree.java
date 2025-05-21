/*
We can perform any traversal except level order traversal as
Level order traversal doesn't clearly indicate which nodes are children of which parents
when viewed as a flat sequence.
TC->O(N)
SC->O(N)
 */
public class SubTreeOfAnotherTree {
    public String getPreorder(TreeNode root){
        if(root==null) return "#";
        StringBuilder sb=new StringBuilder(",");
        sb.append(root.val);
        sb.append(getPreorder(root.left));
        sb.append(getPreorder(root.right));
        return sb.toString();
    }
    public static void main(String[] args){
        TreeNode A=new TreeNode(3);
        A.left=new TreeNode(4);
        A.right=new TreeNode(5);
        A.left.left=new TreeNode(1);
        A.left.right=new TreeNode(2);
        //A.left.right.left=new TreeNode(0);

        TreeNode B=new TreeNode(4);
        B.left=new TreeNode(1);
        B.right=new TreeNode(2);

        SubTreeOfAnotherTree subTreeOfAnotherTree=new SubTreeOfAnotherTree();
        String mainTree=subTreeOfAnotherTree.getPreorder(A);
        String subTree=subTreeOfAnotherTree.getPreorder(B);

        if(mainTree.contains(subTree)){
            System.out.println("Yes, B is subtree of A");
        }else{
            System.out.println("No, B is not subtree of A");
        }
    }
}
