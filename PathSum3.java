/*
Find number of paths that sum upto a given target.
Path can start and end at any node.
 */
public class PathSum3 {
    public int pathSum(TreeNode root,int target){
        if(root==null){
            return 0;
        }
        return pathSum(root.left,target)+pathSum_a(root,target)+pathSum(root.right,target);
    }

    private int pathSum_a(TreeNode root,int target) {
        if(root==null){
            return 0;
        }
        int res=0;
        if(root.val==target){
            res++;
        }
        res+=pathSum_a(root.left,target- root.val);
        res+=pathSum_a(root.right,target-root.val);
        return res;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(-3);
        root.right.right=new TreeNode(11);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(2);
        root.left.left.left=new TreeNode(3);
        root.left.left.right=new TreeNode(-2);
        root.left.right.right=new TreeNode(1);
        PathSum3 pathSum3=new PathSum3();
        int totalPaths=pathSum3.pathSum(root,8);
        System.out.println("The total number of paths are "+totalPaths);
    }
}
