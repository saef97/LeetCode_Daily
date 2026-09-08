class Solution {
    void dfs(char[][] grid,int i,int j){
        int [][]dir = {{0,-1},{-1,0},{1,0},{0,1}};
        int m = grid.length;
        int n = grid[0].length;
        if(i<0||i>=m || j<0 ||j>=n){
            return;
        }
        if(grid[i][j] == '0')return ;
        if(grid[i][j] == '2')return;
        grid[i][j] = '2';
        //if
        for(int []d:dir){
            int newI = i+d[0];
            int newJ = j+d[1];
            dfs(grid,newI,newJ);
        }
        
    }

    public int numIslands(char[][] grid) {
        int count = 0; int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }

            }
        }
        return count;
    }
}