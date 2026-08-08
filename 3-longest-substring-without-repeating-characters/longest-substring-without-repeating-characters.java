class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;int j = 0;
        int n = s.length();int max = 0;
        StringBuilder sv = new StringBuilder();
        while(j<n){
            char c = s.charAt(j);
            if(!sv.toString().contains(String.valueOf(c))){
                sv.append(c); max = Math.max(max,sv.length());//max ko humesha banate time add kro;
            }
            else{
               
                if(!sv.isEmpty())
                sv.deleteCharAt(0);
                i++;j--;
            }
            j++;
        }
        return max;
    }
}