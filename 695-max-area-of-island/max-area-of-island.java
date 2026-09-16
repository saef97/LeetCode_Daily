class Solution {
    private int dfs(int[][] grid, int i, int j) {

        grid[i][j] = 0; // marking visited;
        int area = 1;

        int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        for (int[] d : dir) {
            int newI = i + d[0];
            int newJ = j + d[1];
            if (newI < 0 || newJ < 0 || newI >= grid.length || newJ >= grid[i].length || grid[newI][newJ] == 0) {
                continue;
            }

            area += dfs(grid, newI, newJ);
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int currArea = 0;
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(dfs(grid, i, j),maxArea);
                }
                //maxArea = Math.max(maxArea, currArea);
            }
        }
        return maxArea;
    }
}