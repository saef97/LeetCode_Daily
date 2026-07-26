class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0;int h = n-1;
        int  mid = 0;
        while(mid<=h){
            if(nums[mid] == 0){
                int temp = nums[l];
                nums[l++] = nums[mid];
                nums[mid++] = temp;//mid kp bhi aage cha;lana hai
            }else if(nums[mid] == 1){
                mid++;
            }else{
                int temp = nums[mid];
                nums[mid] = nums[h];
                nums[h--] = temp;

            }
        }
    }
}