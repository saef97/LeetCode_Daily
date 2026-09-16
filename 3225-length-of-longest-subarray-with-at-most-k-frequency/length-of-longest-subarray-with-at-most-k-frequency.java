class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i = 0;int j = 0;
        int n = nums.length;
        int count = 0;
        int maxLen = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(j<n){
            int curr = nums[j];
            map.put(curr,map.getOrDefault(curr,0)+1);
           // count = Math.max(map.get(curr),count);
            while(map.get(curr) > k){
               
                map.put(nums[i],map.get(nums[i])-1);
                // if(map.get(curr) <= k){
                //     count--;
                // }
               
                i++;
            }
             maxLen = Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}