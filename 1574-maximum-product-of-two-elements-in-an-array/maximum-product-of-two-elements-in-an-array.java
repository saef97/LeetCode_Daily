class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(nums[i] > max){
                min = max;
                max = nums[i];
            }else{
                min = Math.max(min,nums[i]);
            }
        }
        return (min-1)*(max-1);
    }
}