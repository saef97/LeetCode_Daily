class Solution {
    public int minimumPushes(String word) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char c:word.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int ans = 0;
        List<Integer> val = new ArrayList<>(map.values());
        val.sort(Collections.reverseOrder());

        for(int i = 0;i<val.size();i++){
            if(i<8){
                ans += (val.get(i)*1);
            }else if(i<16){
                ans+=(val.get(i)*2);
            }else if(i<24){
                ans+=(val.get(i)*3);
            }else {
                ans +=(val.get(i)*4);
            }
        }
        return ans;
       
    }
}