class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        Set<Integer> set = new HashSet<>();

        for(int x:nums){
            set.add(x);
        }int max = 0;
        //nt currLength = 0;
        for(int x:set){
            if(!set.contains(x-1)){
                int num = x;
                int currLength = 1;
                while(set.contains(num+1)){
                    num++;
                    currLength++;
                }
                max  = Math.max(max,currLength);
                
            }
            
        }
        return max;
    }
}