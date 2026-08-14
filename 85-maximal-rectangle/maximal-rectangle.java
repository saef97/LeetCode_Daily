class Solution {
     ArrayList<Integer> psl(int []nums){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();

        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans.add(-1);
            }else{
                ans.add(st.peek());
            }
            st.push(i);
        }
        return ans;
    }
     ArrayList<Integer> nsl (int[] nums){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();
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
    int MAH  (int [] nums){
         ArrayList<Integer> ps = psl(nums);
          ArrayList<Integer> ns = nsl(nums);
          int max = 0;int n = nums.length;
        for(int i = 0;i<n;i++){
            int left = ps.get(i);
            int right = ns.get(i);
            int s = (right-left-1)*nums[i];
            max = Math.max(max,s);
           
        }
        return max;
         
    }
    public int maximalRectangle(char[][] matrix) {
if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        int n = matrix[0].length;
        int m = matrix.length;
        int [] mai  = new int [n];
        for(int i  = 0;i<m;i++){
            for(int j = 0;j<n;j++){
               // mai[j] += matrix[i][j]; 
               if(matrix[i][j] == '1'){
                mai[j]++;
               }else{
                mai[j] = 0;
               }
            }
            int currmah = MAH(mai);
            max = Math.max(max,currmah);
        }
        return max;
        
        
        
    }
}