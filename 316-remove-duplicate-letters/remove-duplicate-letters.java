class Solution {
    public String removeDuplicateLetters(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        Map<Character,Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int n = s.length();
        char [] arr = s.toCharArray();
        for(int i = n-1;i>=0;i--){
            map.putIfAbsent(arr[i],i);
        }

        for(int i = 0;i<n;i++){
            char curr = arr[i];
            if (set.contains(curr))continue;
            while(
                !st.isEmpty() &&
                curr < st.peek() &&
                map.get(st.peek()) > i
            ){
                set.remove(st.pop());
            }
            st.push(curr);
            set.add(curr);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}