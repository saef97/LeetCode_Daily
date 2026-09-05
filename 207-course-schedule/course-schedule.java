class Solution {
    List<List<Integer>> adj;
    int[] state;

    boolean hasACycleDfs(int node) {
        state[node] = 1;
        for (int num : adj.get(node)) {
            if (state[num] == 1)
                return true;
            if (state[num] == 0) {
                if (hasACycleDfs(num))
                    return true;
            }
        }
        state[node] = 2;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        int n = numCourses;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];

            adj.get(u).add(v);
        }
        state = new int[n];
        for (int i = 0; i < n; i++) {
            if (state[i] == 0) {
                if (hasACycleDfs(i))
                    return false;
            }
        }
        return true;

    }
}