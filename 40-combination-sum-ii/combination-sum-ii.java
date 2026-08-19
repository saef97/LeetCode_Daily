class Solution {
    void backtrack(int start,int currSum,int []nums,List<List<Integer>> res,List<Integer> currList,int target){
        if(currSum == target){
            res.add(new ArrayList<>(currList));
            return;
        }
        if(currSum > target)return;
        for(int i = start;i<nums.length;i++){
            if(i>start && nums[i] == nums[i-1])continue;
            currList.add(nums[i]);
            backtrack(i+1,currSum+nums[i],nums,res,currList,target);
            currList.remove(currList.size()-1);
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,0,candidates,res,currList,target);
        return res;
    }
}