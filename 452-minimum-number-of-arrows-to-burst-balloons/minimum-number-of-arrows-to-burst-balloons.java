class Solution {
    public int findMinArrowShots(int[][] points) {
        //count number of overlappings
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int last = points[0][1];
        int n = points.length;
        int count = 1;
        for(int i = 1;i<n;i++){
            if(last < points[i][0]){
                count++;
                last = points[i][1];
            }
        }
        return count;
    }
}