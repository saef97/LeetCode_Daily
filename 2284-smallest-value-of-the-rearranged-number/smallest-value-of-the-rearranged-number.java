class Solution {
    public long smallestNumber(long num) {
        if(num == 0)return 0;
        String s = String.valueOf(Math.abs(num));
        List<Character> list = new ArrayList<>();
        for(char c:s.toCharArray()){
            list.add(c);
        }
        
        if(num < 0){
         //desc
         Collections.sort(list,Collections.reverseOrder());
        }else{
            //asc
            Collections.sort(list);
            if(list.get(0) == '0'){
                int i= 0;
                while(i<s.length() && list.get(i) == '0'){
                    i++;
                }
                char temp = list.get(i);
                list.set(i,'0');
                list.set(0,temp);
            }

        }

        StringBuilder sb = new StringBuilder();
        if(num < 0)sb.append('-');
        for(char c:list){
            sb.append(c);
        }
        long res = 0;
       
            res = Long.parseLong(sb.toString());
            return res;
       
        
    }
}