class Solution {
    void backtrack(int start,int [] nums,List<List<Integer>> res,List<Integer> currList){
        res.add(new ArrayList<>(currList));

        for(int i =start;i<nums.length;i++){
            if(i>start && nums[i] == nums[i-1]){
                continue;
            }
            currList.add(nums[i]);
            backtrack(i+1,nums,res,currList);
            currList.remove(currList.size()-1);

        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,nums,res,currList);
        return res;
    }
}