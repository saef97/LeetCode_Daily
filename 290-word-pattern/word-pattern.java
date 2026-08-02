class Solution {
    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();
        String [] strs = s.split(" ");
        Map<Character,String> map1 = new HashMap<>();
        Map<String,Character> map2 = new HashMap<>();

        if(n != strs.length)return false;
        for(int i = 0;i<n;i++){
            char c = pattern.charAt(i);
            String st = strs[i];
            if(map1.containsKey(c) && !map1.get(c).equals(st)){
                return false;
            }
            if(map2.containsKey(st) && !map2.get(st).equals(c)){
                return false;
            }
            map1.put(c,st);
            map2.put(st,c);
        }
        return true;
        
        //return true;
    }
}