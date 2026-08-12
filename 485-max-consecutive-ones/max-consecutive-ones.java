class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;int n = nums.length;
        int maxCount = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] == 1){
                
                count = count+1;
            }else{
                
                count = 0;
            }
            maxCount   = Math.max(maxCount,count);
            
        }
        return maxCount; 
    }
}