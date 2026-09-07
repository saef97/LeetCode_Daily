class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u).add(new int[]{v,w});

        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        int [] dist = new int[n+1];
        int src = k;
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        minHeap.offer(new int[]{src,0});

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int u = curr[0];
            int distFromSrc = curr[1];

            if(distFromSrc > dist[u])continue;

            for(int [] edges:adj.get(u)){
                int v = edges[0];
                int weight = edges[1];

                if(dist[u]+weight < dist[v]){
                    dist[v] = dist[u]+weight;
                    minHeap.offer(new int[]{v,dist[v]});
                }
            }
        }
        int max = 0;
        for(int i = 1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE)return -1;
            max = Math.max(max,dist[i]);
        }
        return max;

    }
}