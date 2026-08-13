class Solution {
    Map<Integer,Integer> map;
    void nextGreater(int[] nums) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        //ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        map = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            int curr = nums[i];
            while (!st.isEmpty() && st.peek() <= curr) {
                st.pop();
            }
            if (!st.isEmpty()) {
                //ans.add(st.peek());
                map.put(curr,st.peek());
            } else {
                //ans.add(-1);
                map.put(curr,-1);
            }
            st.push(curr);

        }
        
       // Collections.reverse(ans);
        //return map;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int []ans = new int[n];
       //ArrayList<Integer> res = 
       nextGreater(nums2);
        // for(int i = 0;i<n;i++){
        //     ans[i] = res.get(i);
        // }
       // int i = 0;
        // for(int a:map.values()){
        //     ans[i++] = a;
        // }
        for(int i = 0;i<nums1.length;i++){
           // int v = 
            ans[i]  = map.get(nums1[i]);
        }
      

        return ans;
        
    }
}