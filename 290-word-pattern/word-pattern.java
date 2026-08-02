class Solution {
    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();
        String [] strs = s.split(" ");
        Map<Character,String> map = new HashMap<>();
        if(n != strs.length)return false;
        for(int i = 0;i<n;i++){
            char curr = pattern.charAt(i);
            String val  = strs[i];
            if(!map.containsKey(curr)){
                if(!map.containsValue(val)){
                    map.put(curr,val);
                }else{
                    return false;
                }

            }else if(map.containsKey(curr)){
                if(!map.get(curr).equals(val)){
                    return false;
                }
            }
        }
        return true;
    }
}