class Solution {
    boolean [][] visited;
    boolean dfs(int i,int j,int parentI,int parentJ,char[][]grid){
        visited[i][j] = true;
        int [][]dir ={{0,-1},{0,1},{-1,0},{1,0}};
        int m = grid.length;
        int n = grid[0].length;
        for(int []d:dir){
            int newI = i+d[0];
            int newJ = j+d[1];
            if(newI < 0 || newI >= m || newJ < 0 || newJ >= n){
                continue;
            }
            if(grid[newI][newJ] == grid[i][j]){
                if(!visited[newI][newJ]){
                    if(dfs(newI,newJ,i,j,grid)){
                        return true;
                    }
                }
                else{
                    if(newI == parentI && newJ == parentJ){
                    continue;
                    }else{
                        return true;
                    }
                }

            }
            
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        ArrayDeque<Character> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        for(int i  = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(!visited[i][j]){
                    if(dfs(i,j,-1,-1,grid)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}