class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        int count = 0;
        int last = intervals[0][1];
        for(int i = 1;i<n;i++){
            if(last > intervals[i][0]){
                last = Math.min(intervals[i][1],last);count++;
            }else{
                last = intervals[i][1];
            }
        }
        return count;
    }
}