class Solution {

    int[][][]t;

    int recur(int i, int canBuy, int k,int[] price) {
        int n = price.length;
        if(k == 0)return 0;
        if (i == n)
            return t[i][canBuy][k] = 0;//directly bhi return kar do return 0;

        if (t[i][canBuy][k] != -1)
            return t[i][canBuy][k];
        if (canBuy == 1) {
            int buy = -price[i] + recur(i + 1, 0,k, price);
            int skip = recur(i + 1, 1,k, price);
            return t[i][canBuy][k] = Math.max(buy, skip);
        } else {//canBuy == 0
            int sell = price[i] + recur(i + 1, 1, k-1,price);
            int skip = recur(i + 1, 0,k, price);
            return t[i][canBuy][k] = Math.max(sell, skip);
        }

    }

    //canbuy =1 i am emtpy handed->i can buy or skip only
    //canbuy == 0 ..u have 1 stock to sell or skip
    public int maxProfit(int[] prices) {
        t = new int[prices.length + 1][2][3];
        // Arrays.fill(t,-1);
        for (int i = 0; i < t.length; i++) {
            for(int j =0;j<2;j++){
                Arrays.fill(t[i][j],-1);
            }
        }
        return recur(0, 1,2, prices);

        //memoized me final return call recur hi hogi,,//return t[prices.length][2];

    }
}