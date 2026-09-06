class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int index = 0;
        int n = nums.length;
        ArrayDeque<Integer> list = new ArrayDeque<>();
        int[] res = new int[n - k + 1];
        
        while (j < n) {

            while (!list.isEmpty() && nums[list.peekLast()] < nums[j]) {
                list.removeLast();
            }
            list.addLast(j);

            if (list.peekFirst() < i) {
                list.removeFirst();
                
            }
            if (j - i + 1 == k) {
                res[index++] = nums[list.peekFirst()];
                i++;
            }
            j++;
        }
        return res;
    }
}