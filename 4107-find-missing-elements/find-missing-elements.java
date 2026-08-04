class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = 101;
        int max = 0;int n = nums.length;
        Set<Integer> set = new HashSet<>();
       for(int a:nums){
        min = Math.min(min,a);
        max = Math.max(max,a);
        set.add(a);
       }
       List<Integer> res = new ArrayList<>();
       //return new ArrayList<>(List.of(min,max));
       for(int i = min;i<max;i++){
        if(!set.contains(i)){
            res.add(i);
        }
       }
       return res;
    }
}