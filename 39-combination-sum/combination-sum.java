class Solution {
    void backtrack(int start,int currSum,int[]nums,List<Integer> currList,List<List<Integer>> res,int target){
        if(target == currSum){
            res.add(new ArrayList<>(currList));
            return;
        }
        if(currSum > target)return;
        for(int i = start;i<nums.length;i++){
            //currSum +=nums[i];
            currList.add(nums[i]);
            backtrack(i,currSum+nums[i],nums,currList,res,target);
            currList.remove(currList.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backtrack(0,0,candidates,currList,res,target);
        return res;
    }
}