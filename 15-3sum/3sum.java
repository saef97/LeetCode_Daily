class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            int l = i+1;
            int r = n-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum == 0){
                    set.add(Arrays.asList(nums[i],nums[l],nums[r]));
                }
                if(sum < 0){
                    l++;
                }else{
                    r--;
                }
            }
            
        }
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }
}