class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            int ind = val - 1;
            if (nums[ind] < 0) {
                res[0] = val;
            } else {
                nums[ind] = -nums[ind];
            }

        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                //res[0] = i;
                res[1] = i + 1;
            }
        }
        return res;
    }
}