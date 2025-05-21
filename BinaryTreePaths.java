import java.util.ArrayList;

/*
You will be given a target node, you need to find out the path from root to the target.
The target node may or may not be present in the tree
TC->O(N)
SC->O(H)
 */
public class BinaryTreePaths {
    public boolean getPath(TreeNode root, int target, ArrayList<Integer> ans){
        if(root==null){
            return false;
        }
        ans.add(root.val);
        if(root.val==target){
            return true;
        }
        if((getPath(root.left,target,ans)) || (getPath(root.right,target,ans))){
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.right.left=new TreeNode(6);
        root.left.right.right=new TreeNode(7);
//        root.left.right.right=new TreeNode(8);
        BinaryTreePaths binaryTreePaths=new BinaryTreePaths();
        ArrayList<Integer> ans=new ArrayList<>();
        if(binaryTreePaths.getPath(root,7,ans)){
            System.out.println("The path to reach from "+root.val+"to target 7 is");
            for(int i:ans){
                System.out.print(i+"->");
            }
        }else{
            System.out.println("The target node is not present in the tree");
        }
    }
}
