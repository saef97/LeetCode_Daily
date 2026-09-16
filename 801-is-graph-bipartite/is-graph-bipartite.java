class Solution {
    int []color;
    boolean bfs(int node,int currColor,int [][] graph){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        color[node] = currColor;
        q.offer(node);
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v:graph[u]){
                if(color[v] == color[u])return false;
                if(color[v] == -1){
                    //int colorV = 1-currColor;
                    color[v] = 1-color[u];
                    q.offer(v);
                }
            }
        }
        return true;

    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color,-1);
        
        for(int i = 0;i<n;i++){
            if(color[i] == -1){
                if(!bfs(i,0,graph)){
                    return false;
                }
            }
        }
        return true;
    }
}