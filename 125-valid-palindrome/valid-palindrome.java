class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb= new StringBuilder();
        for(char c:s.toCharArray()){
            // if((c >= 'a' && c<='z') || (c<='Z' && c>='A')){
            //     if(Character.isUpperCase(c)){
            //         c = Character.toLowerCase(c);
            //     }
            //     sb.append((c));//no need for wrapper
            // }
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        if (sb.toString().equals("")) return true;
        if(sb.toString().equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }
}