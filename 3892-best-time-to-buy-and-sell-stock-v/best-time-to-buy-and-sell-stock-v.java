class Solution {
    long [][][] t;

    long recur(int i, int canBuy, int k, int[] price) {
        int n = price.length;
        if (k == 0)
            return 0;
        if (i == n){
            if(canBuy == 1)return 0;
            else{
                return -100000000000000L;
            }
        }


        if (t[i][canBuy][k] != -1)
            return t[i][canBuy][k];
        if (canBuy == 1) {//empty hand

            long buy = -price[i] + recur(i + 1, 0, k, price);
            long skip = recur(i + 1, 1, k, price);
            long shortSell = price[i] + recur(i + 1, 2, k, price);

            return t[i][canBuy][k] = Math.max(buy, Math.max(skip, shortSell));

        } else if (canBuy == 0) {//have a stock

            long sell = price[i] + recur(i + 1, 1, k - 1, price);
            long skip = recur(i + 1, 0, k, price);
            return t[i][canBuy][k] = Math.max(sell, skip);

        } else {//ss //empty hand
            long buyBack = -price[i] + recur(i + 1, 1, k - 1, price);
            long skip = recur(i + 1, 2, k, price);
            return t[i][canBuy][k] = Math.max(buyBack, skip);

        }

    }

    public long maximumProfit(int[] prices, int k) {

        t = new long[prices.length + 1][3][k + 1];

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(t[i][j], -1);
            }
        }
        return recur(0, 1, k, prices);

    }
}