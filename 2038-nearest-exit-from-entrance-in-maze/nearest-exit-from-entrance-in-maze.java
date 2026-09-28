class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int count = 0;
        int min = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[m][n];
        q.offer(new int[] { entrance[0], entrance[1] });
        visited[entrance[0]][entrance[1]] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();

                int oldI = curr[0];
                int oldJ = curr[1];
                for (int[] d : dir) {
                    int newI = oldI + d[0];
                    int newJ = oldJ + d[1];
                    if (newI >= m || newI < 0 || newJ >= n || newJ < 0)
                        continue;
                    if (!visited[newI][newJ] && maze[newI][newJ] == '.') {
                        if (newI == (m - 1) || newJ == (n - 1) || newI == 0 || newJ == 0) {
                            return count;
                        }
                        q.offer(new int[] { newI, newJ });
                        visited[newI][newJ] = true;

                    }
                }
            }
            // min = Math.min(count,min);
        }
        return -1;

    }
}