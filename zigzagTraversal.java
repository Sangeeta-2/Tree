import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
We have to traverse the graph in zig zag fashion like one level if we traverse from left,
then in the next level we need to traverse it from right.
TC->O(N)
SC->O(N)
 */
public class zigzagTraversal {

    public ArrayList<ArrayList<Integer>> zigzagOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean flag = true; // true means left to right, false means right to left

        queue.add(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> levelList = new ArrayList<>();

            // Pre-fill the level list with placeholder values (we'll override them)
            for(int i = 0; i < levelSize; i++) {
                levelList.add(0); // Adding placeholders
            }

            for(int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                // For even levels (flag=true), add at position i
                // For odd levels (flag=false), add at position (levelSize-1-i)
                if(flag) {
                    levelList.set(i, current.val);
                } else {
                    levelList.set(levelSize - 1 - i, current.val);
                }

                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }

            ans.add(levelList);
            flag = !flag; // Toggle the direction for next level
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        zigzagTraversal obj = new zigzagTraversal();
        ArrayList<ArrayList<Integer>> zigzagOrderTraversalList = obj.zigzagOrder(root);

        System.out.println("Zigzag Level Order Traversal:");
        for(int i = 0; i < zigzagOrderTraversalList.size(); i++) {
            System.out.println("Level " + i + ": " + zigzagOrderTraversalList.get(i));
        }
    }
}
