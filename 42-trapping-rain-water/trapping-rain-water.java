class Solution {
    public int trap(int[] height) {
        int left = 0;
        int total = 0;
        int n = height.length;
        int maxL = 0;int maxR = 0;
        int right = n-1;
        while(left< right){
            if(height[left] <=height[right]){
                if(maxL <= height[left]){
                    maxL =height[left];
                }else{
                    total +=(maxL-height[left])<0?0:maxL-height[left];
                }
                left++;
            }else{
                if(maxR <=height[right]){
                    maxR = height[right];
                }else{
                    total+=Math.max(0,maxR-height[right]);
                }
                right--;
            }
        }
        return total;
    }
}