class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int lastEnd = intervals[0][1];
        int lastStart = intervals[0][0];
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        for(int i = 1;i<n;i++){
            if(lastEnd >= intervals[i][0]){
                //intervals[i][0] = 
                lastEnd = Math.max(intervals[i][1],lastEnd);
            }else{
                res.add(new int[]{lastStart,lastEnd});
                lastStart = intervals[i][0];
                lastEnd = intervals[i][1];
            }

            //laste = intervals[i][1];
        }
        res.add(new int[]{lastStart,lastEnd});
        int [][] ans = new int [res.size()][2];
        int i = 0;
        for(int []a:res){
            ans[i++] =a ;

        }
        return ans;
    }
}