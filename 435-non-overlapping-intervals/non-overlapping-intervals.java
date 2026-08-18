class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       Arrays.sort(intervals,(a,b)->{
        if(b[1] == a[1]){
           return  Integer.compare(a[0],b[0]);
        }else{
           return  Integer.compare(a[1],b[1]);
        }
       });
        int n = intervals.length;
        int last = intervals[0][1];
        int count = 0;
        for(int i =1 ;i<n;i++){
            if(last >intervals[i][0]){
                count++;
                
            }else{
                last = intervals[i][1];
            }
        }
        return count;
    }
}