class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;int j = 0;int n = s.length();
        int maxLen = 0;int start = 0;
        while(j<n){
            char c = s.charAt(j);
            if(!set.contains(c)){
                set.add(c);
                maxLen = Math.max(maxLen,set.size());
                j++;
            }else{
                
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLen;
    }
}