class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //int and = 1;
        List<int[]> list = new ArrayList<>();
        // Map<int[],Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[] { i, j });
                }
            }

        }
        int i = 0;
        int j = 0;
        for (int k = 0; k < list.size(); k++) {
            int[] arr = list.get(k);
            i = arr[0];
            j = arr[1];

            for (int x = 0; x < m; x++) {
                matrix[x][j] = 0;
            }

            for (int y = 0; y < n; y++) {
                matrix[i][y] = 0;
            }
        }

    }
}