class Solution {
    int size;
    // int c0g ;int c1g;
    int [][][] t;
    int[] zero;
    int[] one;

    int solve(String[] strs, int i, int m, int n) {
        //int c0 = 0;
       // int c1 = 0;
       if(t[i][m][n] != -1)return t[i][m][n];
        if (i == size)
            return t[i][m][n] = 0;

        if (zero[i] <= m && one[i] <= n) {
            // m-=zero[i];
            //m-=one[i];
            return t[i][m][n] = Math.max(1 + solve(strs, i + 1, m - zero[i], n - one[i]), solve(strs, i + 1, m, n));
        } else {
            return t[i][m][n] = solve(strs, i + 1, m, n);
        }
    }

    public int findMaxForm(String[] strs, int m, int n) {
        size = strs.length;
        // c0g = 0;c1g =0;
        zero = new int[size];
        one = new int[size];
        t = new int [size+1][m+1][n+1];
        for(int i = 0;i<size;i++){
            for(int j = 0;j<=m;j++)
            Arrays.fill(t[i][j],-1);
        }

        for (int i = 0; i < size; i++) {
            int c0 = 0;
            int c1 = 0;
            String curr = strs[i];
            for (char c : curr.toCharArray()) {
                if (c == '0') {
                    c0++;
                    // c0g++;
                } else {
                    c1++;
                    // c1g++;
                }
            }
            zero[i] = c0;
            one[i] = c1;
        }
        return solve(strs, 0, m, n);
    }
}