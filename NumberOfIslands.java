import java.util.LinkedList;
import java.util.Queue;

/*
Need to find out num ber of islands for a given m*n matrix.
TC->O(N^2)
SC->O(N^2)
 */
class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
public class NumberOfIslands {
    public int numberOfIslands(int[][] grid){
       int[][] visited=new int[grid.length][grid[0].length];
       int count = 0;
       for(int i=0;i< grid.length;i++){
           for(int j=0;j<grid[0].length;j++){
               if(grid[i][j]==1 && visited[i][j]==0){
                   count++;
                   bfs(i,j,grid,visited);
               }
           }
       }
       return count;
    }

    private void bfs(int row, int col, int[][] grid, int[][] visited) {
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(row,col));
        while(!queue.isEmpty()){
            int r=queue.peek().row;
            int c=queue.peek().col;
            visited[r][c]=1;
            queue.poll();
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int nrow=r+i;
                    int ncol=c+j;
                    if(nrow>=0 && nrow< grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
                        queue.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        int[][] grid={
                {0,1,1,0},
                {0,1,1,0},
                {0,0,1,0},
                {0,0,0,0},
                {1,1,0,1}
        };
        NumberOfIslands noi=new NumberOfIslands();
        int count=noi.numberOfIslands(grid);
        System.out.println("The total number of islands are "+count);
    }
}
