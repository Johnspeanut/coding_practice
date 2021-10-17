import java.util.LinkedList;
import java.util.Queue;

class RottenOranges{

  public static void main(String[] args) {
    RottenOranges rottenOranges = new RottenOranges();
    int[][] gird = {{2,1,1},{1,1,0},{0,1,1}};
    int result = rottenOranges.orangesRotting(gird);
  }
  public int orangesRotting(int[][] grid) {
    Queue<int[]> pq = new LinkedList<>();
    boolean[][] visited = new boolean[grid.length][grid[0].length];

    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[0].length; j++){
        if(grid[i][j] == 2){
          pq.offer(new int[]{i,j});
          visited[i][j] = true;
        }
      }
    }
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int time = 0;
    while(!pq.isEmpty()){
      for(int k = 0; k < pq.size(); k++){
        int[] cur = pq.poll();
        for(int[] dir:dirs){
          int x=cur[0]+dir[0];
          int y=cur[1]+dir[1];
          if(x >= 0 && x < grid.length && y >=0 && y<grid[0].length&& visited[x][y]==false && grid[x][y]==1){
            pq.offer(new int[]{x, y});
            visited[x][y] = true;
            grid[x][y]=2;
          }
        }
      }
      time ++;
    }
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[0].length; j++){
        if(grid[i][j] == 1){
          return -1;
        }
      }
    }
    return time == 0?0:time-1;
  }
}