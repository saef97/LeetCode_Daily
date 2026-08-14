class Solution {
    void bfs(int source, int[][] mat, boolean[] visited) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int j = 0; j < mat.length; j++) {
                if (mat[node][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    q.offer(j);
                }

            }
        }

    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i]) {
                    count++;
                    bfs(i, isConnected, visited);
                }
            }
        }
        return count;
    }
}