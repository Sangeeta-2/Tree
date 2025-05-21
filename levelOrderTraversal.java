import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Here we need to travel level wise
TC->O(N)
SC->O(N)
 */
public class levelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
        if(root == null){
            return new ArrayList<>(); // Return empty list instead of null
        }
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<ArrayList<Integer>> levelWiseTraversal=new ArrayList<>();
        int level=0;
        queue.add(root);
        while(!queue.isEmpty()){
            level=queue.size();
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<level;i++){
                int node=queue.peek().val;
                list.add(node);
                if(queue.peek().left!=null){
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.add(queue.peek().right);
                }
                queue.poll();
            }
            levelWiseTraversal.add(list);
        }
        return levelWiseTraversal;
    }
    public static void main(String[] args) {
        // Create a sample binary tree
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Create instance of class to call levelOrder method
        levelOrderTraversal lot = new levelOrderTraversal();
        ArrayList<ArrayList<Integer>> result = lot.levelOrder(root);

        // Print the level order traversal
        System.out.println("Level Order Traversal:");
        for(int i = 0; i < result.size(); i++) {
            System.out.println("Level " + i + ": " + result.get(i));
        }
    }
}

