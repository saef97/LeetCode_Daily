class Solution {
    void backtrack(int start,int k,int []nums,List<List<Integer>> res,List<Integer> currList){
        if(k== currList.size()){
            res.add(new ArrayList<>(currList));
        }
        for(int i = start;i<nums.length;i++){
            currList.add(nums[i]);
            backtrack(i+1,k,nums,res,currList);
            currList.remove(currList.size()-1);
        }


    }
   public List<List<Integer>> combine(int n, int k) {
        int []nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = i+1;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backtrack(0,k,nums,res,currList);
        return res;
        //no duplicates

    }
}