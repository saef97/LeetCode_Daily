class Solution {
    int [][]t;
    //int knapsack
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        t = new int[n+1][amount+1];
        int maxV = Integer.MAX_VALUE-1;
        for(int i = 0;i<=n;i++){
            t[i][0] = 0;
        }
        for(int j = 0;j<=amount;j++){
            t[0][j] = maxV;
        }
        for(int i = 1;i<=n;i++ ){
            for(int j = 1;j<=amount;j++){
                if(coins[i-1] <=j){
                    t[i][j] = Math.min(1+t[i][j-coins[i-1]],t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        if(t[n][amount] == maxV)
    return -1;
        return t[n][amount];
    }
}