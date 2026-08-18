class Solution {
    void backtrack(int []nums,
                    List<Integer> currList,
                    List<List<Integer>> res,
                    boolean [] used){
        if(nums.length == currList.size()){
            res.add(new ArrayList<>(currList));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            if(i>0 && nums[i-1] == nums[i] && !used[i-1]){
                continue;
            }
            //do
            used[i] = true;
            currList.add(nums[i]);

            backtrack(nums,currList,res,used);

            used[i] = false;
            currList.remove(currList.size() -1);

        }
                    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        Arrays.sort(nums);
        boolean [] used = new boolean[nums.length];
        backtrack(nums,currList,res,used);
        return res;

    }
}