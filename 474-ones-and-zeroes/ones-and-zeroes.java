class Solution {
    int size;

    int[][][] t;
    int[] zero;
    int[] one;

    int solve(String[] strs, int m, int n) {

        // if (t[][m][n] != -1)
        //     return t[i][m][n];
        // if (i == size)
        //     return t[i][m][n] = 0;

        // if (zero[i] <= m && one[i] <= n) {
        //     return t[i][m][n] = Math.max(1 + solve(strs, i + 1, m - zero[i], n - one[i]), solve(strs, i + 1, m, n));
        // } else {
        //     return t[i][m][n] = solve(strs, i + 1, m, n);
        // }

       for (int i = size - 1; i >= 0; i--) {

    for (int zeros = 0; zeros <= m; zeros++) {

        for (int ones = 0; ones <= n; ones++) {

            t[i][zeros][ones] = t[i + 1][zeros][ones];

            if (zero[i] <= zeros && one[i] <= ones) {

                t[i][zeros][ones] = Math.max(
                    t[i][zeros][ones],
                    1 + t[i + 1][zeros - zero[i]][ones - one[i]]
                );
            }
        }
    }
}
        return t[0][m][n];

    }

    public int findMaxForm(String[] strs, int m, int n) {
        size = strs.length;

        zero = new int[size];
        one = new int[size];
        t = new int[size + 1][m + 1][n + 1];
        // for (int i = 0; i < size; i++) {
        //     for (int j = 0; j <= m; j++)
        //         Arrays.fill(t[i][j], -1);
        // }

        for (int i = 0; i < size; i++) {
            int c0 = 0;
            int c1 = 0;
            String curr = strs[i];
            for (char c : curr.toCharArray()) {
                if (c == '0') {
                    c0++;

                } else {
                    c1++;

                }
            }
            zero[i] = c0;
            one[i] = c1;
        }
        return solve(strs, m, n);
    }
}