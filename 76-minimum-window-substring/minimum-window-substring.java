class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        //StringBuilder sb = new StringBuilder();
        int j = 0;
        int n = s.length();
        int i = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int count = map.size();
        while(j<n){
            char curr = s.charAt(j);
            if(map.containsKey(curr)){
                map.put(curr,map.get(curr)-1);
                if(map.get(curr)==0){
                    count--;
                }
            }
            while(count == 0){
                if(j-i+1 < min){
                    min = j-i+1;
                    start = i;
                }
                char left = s.charAt(i);
                if(map.containsKey(left)){
                    map.put(left,map.get(left)+1);
                    if(map.get(left) > 0){
                        count++;//now we need it kami uski if -ve to humke duplicates hai

                    }
                }
                i++;
            }
            j++;
            //sb.append(curr);
            //if(int v = )
        }
        return min == Integer.MAX_VALUE?"":s.substring(start,start+min);
    }
}