class Solution {
    void backtrack(int start,int[]nums,List<List<Integer>> res,List<Integer> currList){

        res.add(new ArrayList<>(currList));
  

        for(int i = start;i<nums.length;i++){
            //do
            currList.add(nums[i]);
            //ex
            backtrack(i+1,nums,res,currList);
            //undo;
            currList.remove(currList.size()-1);

        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backtrack(0,nums,res,currList);
        return res;
    }
}