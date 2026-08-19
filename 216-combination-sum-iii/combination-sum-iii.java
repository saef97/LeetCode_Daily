class Solution {
    void backtrack(int start,int k,int currSum,List<List<Integer>> res,List<Integer> currList,int target){
        if(currSum == target && currList.size() == k){
            res.add(new ArrayList<>(currList));
            return;
        }
        if(currSum > target)return;
        for(int i = start;i<10;i++){
            currList.add(i);
            backtrack(i+1,k,currSum+i,res,currList,target);
            currList.remove(currList.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        //int [] nums = new int[9+1];
        // for(int i = 0;i<n;i++){
        //     nums[i] = i+1;
        // }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backtrack(1,k,0,res,currList,n);
        return res;
    }
}