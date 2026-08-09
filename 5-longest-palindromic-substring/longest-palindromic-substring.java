class Solution {
    int [][]t;
    boolean isPal(String s,int left,int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            
            left++;right--;
        }
        return true;
    }
    int maxLen = 0;
    int start = 0;
    String ans ;
    int recur(String s,int i,int j){
        if(t[i][j] != -1){
            return t[i][j];
        }
        if (i == j) {
            if (maxLen < 1) {
                maxLen = 1;
                start = i;
            }
            return t[i][j] = 1;
        }
        // if(i==j)return 1;
        if(isPal(s,i,j)){
            int len = j-i+1;
            
            if(len > maxLen){
                maxLen = len;
                start = i;
            }
            return t[i][j] = len;
            //ans = s.substring(start,start+maxLen); 
        }
        //else{
            return t[i][j] = Math.max(recur(s, i + 1, j),
                recur(s, i, j - 1));
       // }
        //return t[i][j] = maxLen;


    }
    public String longestPalindrome(String s) {
        int n = s.length();
        t = new int[n][n];
        for(int []a:t){
            Arrays.fill(a,-1);
        }
        if(n == 0){
            return "";
        }if(n == 1){
            return s;
        }
        int max = recur(s,0,n-1);
        return ans = s.substring(start,start+maxLen);
    }
}