class Solution {
    public int subarraySum(int[] nums, int k) {
       // if(k <=)
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int n = nums.length;
        int sum = 0;
        int count = 0;
        for(int i = 0;i<n;i++){
            sum +=nums[i];
            int key = sum-k;
            if(map.containsKey(key)){
                count+=map.get(key);
            }
            //if(map.containsKey(key)){
            map.put(sum,map.getOrDefault(sum,0)+1);
            //}
        }
        return count;
    }
}