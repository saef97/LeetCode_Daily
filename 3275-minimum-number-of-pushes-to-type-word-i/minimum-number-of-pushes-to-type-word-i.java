class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        //int mul = 1;
        if(n<=8){
            return 1*n;
        }else if(n<=16){
            return (8*1)+((n-8)*2);
        }else if(n<=24){
            return (8*1)+(8*2)+(n-16)*3;
        }else{
            return (8*1)+(8*2) + (8*3)+(n-24)*4;
        }
        
       
       
    }
}