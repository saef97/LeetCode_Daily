class Solution {
    int overAllMax;
    Integer []t;
    int recur(int i,int[]nums){
        if(i == nums.length-1){
            overAllMax = Math.max(nums[i],overAllMax);
            return nums[i];
            };
        if(t[i] != null)return t[i];
        int maxAti = Math.max(nums[i],nums[i]+ recur(i+1,nums));

        overAllMax = Math.max(overAllMax,maxAti);
        return t[i]=maxAti;
    }
    public int maxSubArray(int[] nums) {
        //DP
        t = new Integer[nums.length];
        overAllMax = nums[0];
       // Arrays.fill(t,)
        recur(0,nums);

        return overAllMax;
        
    }
}