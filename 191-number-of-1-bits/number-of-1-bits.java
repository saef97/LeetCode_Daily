class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        int x = n;
        while(x>0){
            //count +=x&1;
            x = (x & (x-1));
            count++;
        }
        return count;
    }
}