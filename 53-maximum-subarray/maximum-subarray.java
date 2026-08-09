class Solution {
    public int maxSubArray(int[] nums) {
int n = nums.length;
int sum = nums[0];
int max = nums[0];
        for(int i = 1;i<n;i++){
            
                sum = Math.max(sum+nums[i],nums[i]);
max = Math.max(sum,max);
            }
            //max = ;
            return max;
        }
    // int i = 0;int j = 0;int max =0;int n = nums.length;
    // while(j<n){
    //     sum+=nums[j];
    //     j++;

    //     max = Math.max(max,sum);
    // }
}