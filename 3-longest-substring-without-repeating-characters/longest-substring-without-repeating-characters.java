class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;int j = 0;int n = s.length();
        if(s.isEmpty()) return 0;
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        while(j<n){
            char curr = s.charAt(j);
            if(!set.contains(curr)){
            set.add(curr);
            max = Math.max(set.size(),max);
            }else{
                
                //if(!sb.isEmpty())
                set.remove(s.charAt(i));
                i++;j--;
                //sb.append(curr);
            }

            j++;
        }
        return max; 
    }
}