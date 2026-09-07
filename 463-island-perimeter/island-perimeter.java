class Solution {
    int wall;

    void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

    }

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        wall = 0; int[][] dir = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                   
                    for (int[] d : dir) {
                        int newI = i + d[0];
                        int newJ = j + d[1];
                        if ((newI < 0 || newI >= m || newJ < 0 || newJ >= n) || grid[newI][newJ] == 0) {
                            wall++;
                            //newI = i;newJ = j;
                        }
                    }
                    // dfs(grid,i, j);
                    // grid[i][j] = -1;
                }
            }
        }
        return wall;

    }
}