class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [][]t = new int[n+1][2];

        t[n][0] = 0;
        t[n][1] = 0;//bc

        for(int i = n-1;i>=0;i--){
        
            t[i][1] = Math.max(-prices[i]+ t[i+1][0],t[i+1][1]);
       
            t[i][0] = Math.max(prices[i]+t[i+1][1],t[i+1][0]);
        }
        return t[0][1];
    }
}