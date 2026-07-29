class Solution {
    int findDip(int[] arr) {
        int n = arr.length;
        int j = n - 2;

        while (j >= 0 && arr[j] >= arr[j + 1]) {
            j--;
        }
        return j;
        // for (int i = n - 2; i >= 0; i--) {
        //     if (arr[i] < arr[i + 1]) {
        //         return i;

        //     }
        // }

    }

    int findJustGreater(int arr[], int k) {
        //int elem = Integer.MAX_VALUE;
        int n = arr.length;
        int j = n - 1;
        // for(int i = k;i<n;i++){
        //     if(arr[i]> arr[k]){
        //         elem = Math.min(elem,arr[i]);
        //         index = 
        //     }
        // }
        // return elem;
        while (j >= 0 && arr[k] >= arr[j]) {
            j--;
        }
        return j;
    }

    void reverse(int[] arr, int i) {
        int n = arr.length;
        int j = n - 1;
        while (i < j) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivotIndex = findDip(nums);
        if (pivotIndex == -1) {
            reverse(nums, 0);
        } else {
            int nextGreater = findJustGreater(nums, pivotIndex);

            int temp = nums[nextGreater];
            nums[nextGreater] = nums[pivotIndex];
            nums[pivotIndex] = temp;

            reverse(nums, pivotIndex +1);
        }

    }
}