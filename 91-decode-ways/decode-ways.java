class Solution {
    int []t;
    int recursion(String s,int i){
        if(t[i] != -1)return t[i];
      if(i==s.length()){
            return t[i] = 1;
       }
        if(s.charAt(i) == '0'){
            return t[i] = 0;
        }
        int res = recursion(s,i+1);
       // int i2 = 0;
        if(i+1 < s.length()){
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')){
                res += recursion(s,i+2);
            }
        }
        return t[i] = res;
    }
    public int numDecodings(String s) {
        int n = s.length();
        t = new int[n+1];
        Arrays.fill(t,-1);
        return recursion(s,0);
        
    }
}