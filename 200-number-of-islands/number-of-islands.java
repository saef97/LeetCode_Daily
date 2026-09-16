class Solution {
    char[][] visited;

    void dfs(int i, int j, char[][] mat) {
        mat[i][j] = '2';
        int[][] dir = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };
        for (int[] d : dir) {
            int newI = i + d[0];
            int newJ = j + d[1];
            if (newI < 0 || newI >= mat.length || newJ >= mat[0].length || newJ < 0) {
                continue;
            }
            
            if (mat[newI][newJ] == '1') {
                dfs(newI, newJ, mat);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        visited = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);

                }
            }
        }
        return count;

    }
}