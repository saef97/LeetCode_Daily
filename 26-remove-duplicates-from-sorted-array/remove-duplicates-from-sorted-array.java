class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0; int n = nums.length;
        if(n<2)return nums[0];int count = 1;
       int j = 0;
        while(j<n){
            if(nums[i] == nums[j]){
                j++;
            }else{
                nums[i+1] = nums[j];
                count++;
                i++;
            }
        }
        return count;

    }
}