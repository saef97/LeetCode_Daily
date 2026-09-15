class Solution {
    public int characterReplacement(String s, int k) {
       // Map<Charracter,Integer> map = new HashMap<>();
       int [] arr = new int[26];
        int n = s.length();
        int ans = 0;
        int j = 0;int i = 0;int max = Integer.MIN_VALUE;
        while(j<n){
            char curr = s.charAt(j);
            //map.put(curr,map.getOrDefault(curr,0)+1);
            arr[curr-'A']++;
            for(int v:arr){
                max = Math.max(v,max);
            }
            while((j-i+1)-max > k){
                arr[s.charAt(i)-'A']--;
                i++;
            }
            
            ans = Math.max(j-i+1,ans);j++;
            
          
        }
        return ans;
    }
}