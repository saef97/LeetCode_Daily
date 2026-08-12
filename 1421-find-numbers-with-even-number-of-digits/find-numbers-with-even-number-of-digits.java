class Solution {
    int countDigits(int n){
        int count = 0;
        while(n>0){
            n = n/10;
            count++;
        }
        return count;
    }
    public int findNumbers(int[] nums) {
        int n = nums.length;
        int count =0 ;
        for(int i = 0;i<n;i++){
            if(countDigits(nums[i]) %2  == 0){
                count++;
            }
        }
        return count;
        
    }
}