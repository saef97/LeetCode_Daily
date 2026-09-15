class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = 0;
        int n = nums.length;
        int i = 0;int j = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while(j<n){
            sum+=nums[j];
            while(sum >= target){
                min = Math.min(j-i+1,min);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return min == Integer.MAX_VALUE?0:min;
    }
}