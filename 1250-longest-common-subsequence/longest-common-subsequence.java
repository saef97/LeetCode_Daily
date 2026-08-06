class Solution {
    int[][] t;

    int lcs(String text1, String text2, int m, int n) {

        // if (m == 0 || n == 0) {
        //     return t[m][n] = 0;
        // }
        // for (int[] a : t) {
        //     Arrays.fill(a, -1);
        // }
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         t[i][0] = 0;
        //         t[0][j] = 0;
        //     }
        // }
       
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }

        }

        return t[m][n];
        //return 0;
    }

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        t = new int[m + 1][n + 1];
        return lcs(text1,text2,m,n);
    }
}