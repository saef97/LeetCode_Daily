class Solution {
    public int maxProduct(int n) {
        int min = 0;
        int max = 0;
        while (n > 0) {
            int rem = n % 10;
            if(rem>max){
                min = max;
                max = rem;
            }else{
                min = Math.max(min,rem);
            }
            n /= 10;
        }
        return min * max;
    }
}