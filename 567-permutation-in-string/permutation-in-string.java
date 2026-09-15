class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int i = 0;
        int j = 0;
        int n = s2.length();
        //int [] map = new int[128];
        Map<Character,Integer> map = new HashMap<>();
        for(char c:s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count = map.size();
        int min = Integer.MAX_VALUE;
        while(j<n){
            char right = s2.charAt(j);
            if(map.containsKey(right)){
                map.put(right,map.get(right)-1);
                if(map.get(right) == 0){
                    count--;
                }
            }
            while(count == 0){
                min = Math.min(j-i+1,min);
                char left = s2.charAt(i);
                if(map.containsKey(left)){
                    map.put(left,map.get(left)+1);
                    if(map.get(left) > 0){
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return (min == s1.length())?true:false;

    }
}