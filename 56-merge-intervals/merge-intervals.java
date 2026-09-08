class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int n = intervals.length;
        //int [][] res = new int[n][2];
        ArrayList<int[]> res = new ArrayList<>();
        
        int last = intervals[0][1];
        int start = intervals[0][0];
        for(int i = 1;i<n;i++){
            //int [] ans = new int[2];
            if(last >= intervals[i][0])//keep last same
            {
                last = Math.max(last,intervals[i][1]);
            }
            else{
                res.add(new int[]{start,last});
                start = intervals[i][0];
                last = intervals[i][1];
                
            }
            
            


        }
        res.add(new int[]{start,last});
        return res.toArray(new int[res.size()][]);


    }
}