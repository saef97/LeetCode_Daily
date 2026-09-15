class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;int j = 0;int n = s.length();
        if(s.isEmpty()) return 0;
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        while(j<n){
            char curr = s.charAt(j);
            if(!sb.toString().contains(String.valueOf(curr))){
                sb.append(curr);max = Math.max(sb.length(),max);
            }else{
                
                if(!sb.isEmpty())
                sb.deleteCharAt(0);
                i++;j--;
                //sb.append(curr);
            }

            j++;
        }
        return max; 
    }
}