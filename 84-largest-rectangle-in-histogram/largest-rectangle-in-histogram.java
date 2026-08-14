class Solution {
    ArrayList<Integer> psl(int [] nums){
        int n = nums.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();
         ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans.add(st.peek());
            }else{
                ans.add(-1);
            }
            st.push(i);
        }
        return ans;
    }
    ArrayList<Integer> nsl (int []nums){
         int n = nums.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans.add(n);
            }else{
                ans.add(st.peek());
            }
            st.push(i);
        }
        Collections.reverse(ans);
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        ArrayList<Integer> p = psl(heights);
        ArrayList<Integer> nn = nsl(heights);
        int max = 0;
        for(int i = 0;i<n;i++){
            int left = p.get(i);
            int right = nn.get(i);
            int curr = heights[i];
           // while(left < right){
               // elem = heights[left+1]
               int s = (right-left-1)*curr;
               max = Math.max(s,max);
           //    left++;
           // }
        }
        return max;
    }
}