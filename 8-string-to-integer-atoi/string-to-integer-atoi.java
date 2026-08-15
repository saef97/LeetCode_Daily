class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        
       
        if (s.isEmpty()) {
            return 0;
        }

        int sign = 1;
        int i = 0;

       
        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            sign = 1;
            i++;
        }

        int total = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int num = s.charAt(i) - '0';

           
            if (total > Integer.MAX_VALUE / 10 || 
               (total == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + num;
            i++;
        }

        return total * sign;
    }
}