class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0] == b[0]){
                return Integer.compare(b[1],a[1]);
            }else{
                return Integer.compare(a[0],b[0]);
            }
        });
        //Integer.compare(a[0],b[0]));
        int n = intervals.length;
        int count= 1;
        int lastE = intervals[0][1];
        //int lastS = intervals[0][0];
        for(int i = 1;i<n;i++){
            if(intervals[i][1] <= lastE){
                continue;
            }else{
                count++;
                lastE = intervals[i][1];
            }
        }
        return count;
    }
}