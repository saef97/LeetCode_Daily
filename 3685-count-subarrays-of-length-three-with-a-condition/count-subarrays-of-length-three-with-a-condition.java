class Solution {
    public int countSubarrays(int[] nums) {
        int i = 0;
        int j = 0;
        int k =3;
        int count = 0;
        int n = nums.length;
        while(j<n){
            if(j-i+1 < k){
                j++;
            }if(j-i+1 == k){
                int sum = nums[i] + nums[j];
                int mid = nums[j-1];
                if(sum == ((1.0*mid)/2))count++;
                j++;
            i++;
            }
            // j++;
            // i++;
        }
        return count ;
    }
}