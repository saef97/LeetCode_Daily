class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int m = (n) / 2;

       // StringBuilder sb = new StringBuilder();
        char[] st = s.toCharArray();
        Arrays.sort(st,0,m);
        // for (int j = 0; j < m - 1; j++) {
        //     for (int i = 0; i < m - 1 - j; i++) {
        //         if (st[i] > st[i + 1]) {
        //             char c = st[i + 1];
        //             st[i + 1] = st[i];
        //             st[i] = c;

        //         }
        //     } //sb.append(st[j]);
        // }
        //return new String(st);
        StringBuilder rev = new StringBuilder(new String(st,0,m)).reverse();
        StringBuilder sb = new StringBuilder(new String(st,0,m));
        if (n % 2 != 0) {
            sb.append(s.charAt(m)).append(rev);
        } else {
            sb.append(rev);
        }
        return sb.toString();
    }
}