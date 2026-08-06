class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] t = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        int size = t[m][n];
        StringBuilder sb = new StringBuilder();
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));//ye to lcs wale hai to "ab" hoga
                i--;
                j--;
            } else {
                if (t[i][j - 1] > t[i - 1][j]) {
                    sb.append(str2.charAt(j - 1));// ye hai jo match nhi hoga 
                    j--;
                } else {
                    sb.append(str1.charAt(i - 1));
                    i--;
                }
            }
        }
        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        // ye dono while hai agar i = 0/j = 0 ho jaye aur still abhi kuch element bach jaye to

        while(j>0){
            sb.append(str2.charAt(j-1));j--;
        }

        //sb.reverse();
        // StringBuilder ans = new StringBuilder();
        // for(int k =0;k<size;k++ ){
        //     if(sb.charAt(i) != str2.charAt(i)){
        //         ans.append(str2.charAt(i));
        //     }
        // }
        // sb.append(str1);
        return sb.reverse().toString();
    }
}