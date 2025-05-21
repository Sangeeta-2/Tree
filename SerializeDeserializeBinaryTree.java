/*
Here we are using Level order traversal
TC->O(N)
SC->O(N)
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    public String serializeBinaryTree(TreeNode root){
        if(root==null){
            return "";
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node!=null) {
                sb.append(node.val+",");
            }else{
                sb.append("#,");
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);

        }
        return sb.toString();
    }
    public TreeNode deserialize(String serializeString){
        if(serializeString.isEmpty()){
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        String[] values=serializeString.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for(int i=1;i<values.length;i++){
            TreeNode parent=queue.poll();
            if(!values[i].equals("#")){
                parent.left=new TreeNode(Integer.parseInt(values[i]));
                queue.add(parent.left);
            }
            if(!values[++i].equals("#")){
                parent.right=new TreeNode(Integer.parseInt(values[i]));
                queue.add(parent.right);
            }
        }
        return root;
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(13);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(5);
        SerializeDeserializeBinaryTree serializeDeserializeBinaryTree=new SerializeDeserializeBinaryTree();
        String serialize=serializeDeserializeBinaryTree.serializeBinaryTree(root);
        System.out.println("The serialize string is "+serialize);
        TreeNode node=serializeDeserializeBinaryTree.deserialize(serialize);
        //Tree Traversal
        System.out.println("The deserialize tree is ");
        levelOrderTraversal lot=new levelOrderTraversal();
        ArrayList<ArrayList<Integer>> treeTraversal=lot.levelOrder(node);
        for(ArrayList<Integer> level:treeTraversal){
            System.out.println(level);
        }
    }
}
