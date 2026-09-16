class Solution {
    int []t;
    //int min;
    int solve(int i,int []nums){
        if(i >= nums.length-1){
            return  0;
        }
        //if(t[i] == 0)return INteger.
        int min = 10000;
        if(t[i] != -1)return t[i];
        for(int j = 1;j<=nums[i];j++){
            min = Math.min(1+solve(i+j,nums),min);
        }
        return t[i] = min;
    }
    public int jump(int[] nums) {
        
        t = new int[nums.length+1];
        Arrays.fill(t,-1);
        return solve(0,nums);
        //return min;
        
    }
}