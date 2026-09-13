class Solution {
    public int maxProfit(int[] prices) {
        int p = 0;int n = prices.length;
        for(int i =0 ;i<n-1;i++){
            if((prices[i+1]-prices[i]) > 0){
                p+=(prices[i+1]-prices[i]);
            }
        }
        return p;
    }
}