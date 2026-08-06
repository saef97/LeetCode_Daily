class Solution {
    int product(int n){
        int p = 1;
        while(n>0){
            p *= (n%10);
            n = n/10;
        }
        return p;
    }
    public int smallestNumber(int n, int t) {
        
        while(n<101){
            int pro = product(n);
            if(pro%t == 0)return n;
            n++;
        }
        return 0;
       
    }
}