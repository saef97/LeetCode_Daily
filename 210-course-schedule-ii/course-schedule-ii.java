class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        int n  = numCourses;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        //detect a cycle;//using kahns->inorder
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
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(inDegree[i] == 0){
                q.offer(i);
                
            }
        }int processedCount = 0;
        while(!q.isEmpty()){
            
            int curr = q.poll();
            res.add(curr);
            processedCount++;
            for(int num:adj.get(curr)){
                inDegree[num]--;
                if(inDegree[num] == 0){
                    //res.add(num);
                    q.offer(num);
                }
            }
            //visited
        }
        return (processedCount != n)?new int[]{}:(res.stream()
                .mapToInt(Integer::intValue)
                .toArray());

    }
}