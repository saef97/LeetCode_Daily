class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int n  = numCourses;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        //detect a cycle;//using kahns->inorder+visited
        int [] inDegree = new int[n];
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i  = 0;i<prerequisites.length;i++){
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];

            adj.get(u).add(v);
            inDegree[v]++;
        }
        for(int i = 0;i<n;i++){
            if(inDegree[i] == 0){
                q.offer(i);
                
            }
        }int processedCount = 0;
        while(!q.isEmpty()){
            
            int curr = q.poll();
            processedCount++;
            for(int num:adj.get(curr)){
                inDegree[num]--;
                if(inDegree[num] == 0){
                    q.offer(num);
                }
            }
            //visited
        }
        return processedCount == n;

    }
}