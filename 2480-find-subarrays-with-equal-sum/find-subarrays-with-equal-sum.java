class Solution {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;

        for(int i = 0;i<n-1;i++){
            int j = i+1;
            if(set.contains(nums[i]+nums[j])){
                return true;
            }
            set.add(nums[i]+nums[j]);
        }
        return false;
    }
}