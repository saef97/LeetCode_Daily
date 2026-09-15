class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = 0;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            currSum +=num;max =Math.max(currSum,max);
            if(currSum <0){
                currSum = 0;
            }
            
        }
        return max;
    }
}