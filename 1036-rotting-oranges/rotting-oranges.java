class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        int m = grid.length;
        int freshCount = 0;
        int n = grid[0].length;
        //add all rotten oranges in q:(2)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }else if(grid[i][j] ==1){
                    freshCount++;
                }
            }
        }
        if(freshCount == 0)return 0;
        int count = 0;
        int[][] dir = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int oldi = curr[0];
                int oldj = curr[1];

                for (int[] d : dir) {
                    int newI = oldi + d[0];
                    int newJ = oldj + d[1];
                    if ((newI < 0 || newI >= m || newJ < 0 || newJ >= n) || grid[newI][newJ] == 0)
                        continue;
                    if (grid[newI][newJ] == 1) {//unvisited
                        grid[newI][newJ] = 2;
                        freshCount--;
                        q.offer(new int[] { newI, newJ });
                    }
                }
            }if(!q.isEmpty()){
                count++;
            }
            //count++;
            

        }
        return freshCount>0?-1:count;

    }
}