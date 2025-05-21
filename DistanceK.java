/*
Finad all the nodes which are distance k from a given target node.
TC->O(N)+O(K)
SC->O(N)
 */
import java.util.*;

public class DistanceK {
    public ArrayList<Integer> distancek(TreeNode root,TreeNode target,int k){
        Map<TreeNode,TreeNode> parents_track=new HashMap<>();
        ArrayList<Integer> nodesArray=new ArrayList<>();
        Map<TreeNode,Boolean> visited=new HashMap<>();
        int count=0;
        markParents(root,parents_track);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(target);
        visited.put(target,true);
        while(!queue.isEmpty()){
            if(count==k) break;
            count++;
            int size= queue.size();
            for(int i=0;i< size;i++){
               TreeNode currentNode=queue.poll();
               if(currentNode.left!=null && visited.get(currentNode.left)==null){
                   visited.put(currentNode.left,true);
                   queue.add(currentNode.left);
               }
                if(currentNode.right!=null && visited.get(currentNode.right)==null){
                    visited.put(currentNode.right,true);
                    queue.add(currentNode.right);
                }
                if(parents_track.get(currentNode)!=null && visited.get(parents_track.get(currentNode))==null){
                    visited.put(parents_track.get(currentNode),true);
                    queue.add(parents_track.get(currentNode));
                }

            }
        }
        while(!queue.isEmpty()){
            nodesArray.add(queue.poll().val);
        }
        return nodesArray;
    }

    private void markParents(TreeNode root, Map<TreeNode,TreeNode> parentsTrack) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node.left!=null){
                parentsTrack.put(node.left,node);
                queue.add(node.left);
            }
            if(node.right!=null){
                parentsTrack.put(node.right,node);
                queue.add(node.right);
            }
        }
    }
    public static void main(String args[]){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(5);
        root.right=new TreeNode(1);
        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(2);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(8);
        root.left.right.left=new TreeNode(7);
        root.left.right.right=new TreeNode(4);
        DistanceK distK=new DistanceK();
        ArrayList<Integer> nodesArray=distK.distancek(root,root.left,2);
        for(Integer it:nodesArray){
            System.out.print(it+" ");
        }
    }
}
