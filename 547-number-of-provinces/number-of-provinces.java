class Solution {
    class dsu{
        int [] parents;
        int [] rank;
        dsu(int n){
           // this.n = n;
            parents = new int[n];
            rank = new int[n];
            for(int i = 0;i<n;i++){
                parents[i] = i;
                rank[i] = 0;
            }
        }
        int find(int x){
            if(parents[x] != x){
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
        void union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY)return ;

            if(rank[rootX ]< rank[rootY]){
                parents[rootY] = rootX;
            }else if (rank[rootX]>rank[rootY]){
                parents[rootX] = rootY;
            }else{
                parents[rootY] = rootX;
                rank[rootX]++;
            }
            
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        dsu ds = new dsu(n);
        int c =0;
        for(int i = 0;i<n;i++){
            for(int j= 0;j<n;j++){
                if(isConnected[i][j] == 1){
                    ds.union(i,j);
                }
                
            }
            
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            set.add(ds.find(i));
        }
        return set.size();
        

        
    }
}