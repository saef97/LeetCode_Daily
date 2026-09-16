class Solution {
    boolean dfs(int node, int[][] graph, int currColor, int[] color) {
        color[node] = currColor;
        for (int v : graph[node]) {
            if (color[v] == currColor) {
                return false;
            } else if (color[v] == -1) {//not visited
                int colorV = 1 - currColor;
                if (!dfs(v, graph, colorV, color)) {
                    return false;
                }

            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        //ye adj list hi hai
        //int node = graph[0
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for(int i = 0;i<n;i++){
            if(color[i] == -1)
            if(!dfs(i, graph, 0, color)){
                return false;
            }
        }
        return true;

    }
}