class Solution {
    Boolean []t ;
    boolean solve(int i,int []nums){
        
        if(i>= nums.length-1){
            return true;
        }
        if(nums[i] == 0)return false;

        if(t[i]  != null)return t[i];
        for(int j = 1;j<=nums[i];j++){
            if(solve(i+j,nums)){
                return t[i] = true;
            }
        }
        return t[i] = false;
    }
    public boolean canJump(int[] nums) {
        t = new Boolean[nums.length+1];
        //Arrays.fill(t,false);
        return solve(0,nums);
    }
}