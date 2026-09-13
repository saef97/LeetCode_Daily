class Solution {
    int[][] t;

    int recur(int i, int canBuy, int[] price) {
        int n = price.length;
        if (i == n)
            return t[i][canBuy] = 0;//directly bhi return kar do return 0;

        if (t[i][canBuy] != -1)
            return t[i][canBuy];
        if (canBuy == 1) {
            int buy = -price[i] + recur(i + 1, 0, price);
            int skip = recur(i + 1, 1, price);
            return t[i][canBuy] = Math.max(buy, skip);
        } else {//canBuy == 0
            int sell = price[i] + recur(i + 1, 1, price);
            int skip = recur(i + 1, 0, price);
            return t[i][canBuy] = Math.max(sell, skip);
        }
        
    }

    //canbuy =1 i am emtpy handed->i can buy or skip only
    //canbuy == 0 ..u have 1 stock to sell or skip
    public int maxProfit(int[] prices) {
        t = new int[prices.length + 1][2];
        // Arrays.fill(t,-1);
        for (int i = 0; i < t.length; i++) {
            Arrays.fill(t[i], -1);
        }
        return recur(0,1,prices);
        
        //memoized me final return call recur hi hogi,,//return t[prices.length][2];
    }
}