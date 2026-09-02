class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int count = 0;
        int i = 0;
        int j = 0;
        String minString = "";
        int min = Integer.MAX_VALUE;
        int n = s.length();
        String sb = new String();
        while (j < n) {
            //count = 0;
           
            //sb.append(s.chatAt(j));
            if (s.charAt(j) == '1')
                count++;

            while(count == k) {
                 sb = s.substring(i, j + 1);
                // min = Math.min(min,j-i+1);

                if (minString.length() > sb.length() || minString.equals("") ) {
                    minString = sb; 
                    //count = 0;
                } else if (minString.length() == sb.length() && sb.compareTo(minString) < 0) {
                    minString = sb;
                     //count = 0;
                }
                if(s.charAt(i) == '1')count--;
                //minString =
               i++;
                
            }
            

            j++;
        }
       //if(count == 0)return "";
        return minString;
    }
}