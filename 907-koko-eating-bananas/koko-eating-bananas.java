class Solution {
    boolean isValid(int mid,int []arr,int h){
        long totalhrs = 0;
        //int count = 0;
        for(int a:arr){
            // if(a/mid == 0){
            //     totalhrs += 1;
            // }else{
            //     if(a%mid == 0){
            //         totalhrs += a/mid;
            //     }else{
            //         totalhrs += (a/mid)+1;
            //     }
            // }
            totalhrs +=(a+mid-1L)/mid;
            
        }
        return totalhrs <=h;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;

        int ans = 0;

        int hi = 0;
        for(int a:piles){
            hi = Math.max(a,hi);
            //l = Math.min(a,l);
        }
        while(l<=hi){
            int mid = l+(hi-l)/2;
            if(isValid(mid,piles,h)){
                ans = mid;
                hi = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;

    }
}