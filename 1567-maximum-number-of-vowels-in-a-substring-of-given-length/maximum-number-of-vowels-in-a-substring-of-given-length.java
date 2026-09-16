class Solution {
    public int maxVowels(String s, int k) {
        int i = 0;
        int j = 0;int n = s.length();
        char[] vowels = {'a','e','i','o','u'};
        Set<Character> set= new HashSet<>();
        int max = 0;int count = 0;
        for(char c:vowels){
            set.add(c);
        } 
        while(j<n){
            char curr = s.charAt(j);
            if(set.contains(curr)){
                count++;
                
            }
            if(j-i+1 == k){
                max = Math.max(max,count);
                //count = 0;
                
                if(set.contains(s.charAt(i))){
                    //set.remove(s.charAt(i));
                    count--;
                }i++;
                //set.remove(s.charAt(i));
            }
            j++;
        }
        return max;
    }
}