class Solution {
    public int[][] highestPeak(int[][] isWater) {

         Deque<int[]> q = new ArrayDeque<>();
        int m = isWater.length;
        int n = isWater[0].length;
        int [][]dist = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(isWater[i][j] == 1){
                    dist[i][j] = 0;
                    q.offer(new int[]{i,j});
                }else{
                    //freshCount++;
                    dist[i][j] = -1;
                }
            }
        }
        int[][] dir = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int []curr = q.poll();
                int oldI = curr[0];
                int oldJ = curr[1];
                for(int []d:dir){
                    int newI = oldI+d[0];
                    int newJ = oldJ+d[1];
                    if ((newI < 0 || newI >= m || newJ < 0 || newJ >= n) || dist[newI][newJ] != -1){
                        continue;
                    }
                    int abs = Math.abs((dist[oldI][oldJ] +1)-(dist[oldI][oldJ]));
                    if(abs <=1){
                        dist[newI][newJ] = dist[oldI][oldJ] +1;
                    }else{
                        dist[newI][newJ] = dist[oldI][oldJ];
                    }

                    
                    q.offer(new int []{newI,newJ});
                    
                }
            }
           
            
        }
        return dist;
        
    }
}

