class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int n = intervals.length;
       int count = 0;
        //ArrayList<int[]> res = new ArrayList<>();
        
        int last = intervals[0][1];
       // int start = intervals[0][0];
        for(int i = 1;i<n;i++){
          
            if(last > intervals[i][0])
            {
                last = Math.min(last,intervals[i][1]);
                count++;
            }
            else{
                //res.add(new int[]{start,last});
                //start = intervals[i][0];
                last = intervals[i][1];
                
            }
      
        }
        //res.add(new int[]{start,last});
        return count;
    }
}