class Solution {
    void bfs(char[][] grid,int i,int j){
        int [][]dir = {{0,-1},{-1,0},{1,0},{0,1}};
         int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        while(!q.isEmpty()){
            int [] curr = q.poll();
            int oldi =curr[0];
            int oldj = curr[1];

            for(int []d:dir){
                int newI = oldi+d[0];
                int newJ = oldj+d[1];
                if(newI<0 || newJ<0 ||newI >=m || newJ >=n)
                continue;
                if(grid[newI][newJ] == '0')continue;
                if(grid[newI][newJ] == '1'){
                    grid[newI][newJ] = '2';
                    q.offer(new int[]{newI,newJ});
                }
                


            } 
        }
        
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }

            }
        }
        return count;
    }
}