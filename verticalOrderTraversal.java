import java.util.*;

/*
TC->O(N)
SC->O(2N)~O(N)
 */
public class verticalOrderTraversal {
    public ArrayList<ArrayList<Integer>> verticalOrder(TreeNode root){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tupple> queue=new LinkedList<>();
        queue.add(new Tupple(root,0,0));
        while(!queue.isEmpty()){
            TreeNode node=queue.peek().node;
            int vertical=queue.peek().vertical;
            int level=queue.peek().level;
            queue.poll();
            if(!map.containsKey(vertical)){
                map.put(vertical,new TreeMap<>());
            }
            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level,new PriorityQueue<>());
            }
            map.get(vertical).get(level).add(node.val);
            if(node.left!=null){
                queue.add(new Tupple(node.left,vertical-1,level+1));
            }
            if(node.right!=null){
                queue.add(new Tupple(node.right,vertical+1,level+1));
            }
        }
        //Traversing the map
        for(TreeMap<Integer,PriorityQueue<Integer>> tmap:map.values()){
            ArrayList<Integer> nodesVal=new ArrayList<>();
            for(PriorityQueue<Integer> nodes: tmap.values()){
                while(!nodes.isEmpty()){
                    nodesVal.add(nodes.peek());
                    nodes.poll();
                }
            }
            ans.add(nodesVal);
        }
        return ans;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        verticalOrderTraversal vot=new verticalOrderTraversal();
        ArrayList<ArrayList<Integer>> verticalorder=vot.verticalOrder(root);
        for(int i=0;i<verticalorder.size();i++){
            System.out.println(verticalorder.get(i));
        }
    }
}
