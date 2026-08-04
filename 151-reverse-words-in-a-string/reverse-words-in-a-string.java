class Solution {
    public String reverseWords(String s) {

       // String [] strs = s.strip().split(" ");
      // int x = 1;
       List<String> list = new ArrayList<>();
       s = s.strip().replaceAll("\\s+"," ");
       for(String st :s.split(" ")){
        list.add(st);
       }
        int n = list.size();
        StringBuilder sb = new StringBuilder();
        for(int i  = n-1;i>=0;i--){
            sb.append(list.get(i)).append(" ");
        }
        String ss = sb.toString();
        return ss.strip();
    }
}