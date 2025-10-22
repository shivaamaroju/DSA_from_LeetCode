class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] indegree = new int[m][n];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        // Step 1: Compute indegrees
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : dirs) {
                    int ni = i + d[0], nj = j + d[1];
                    if (ni >= 0 && nj >= 0 && ni < m && nj < n && matrix[ni][nj] < matrix[i][j]) {
                        indegree[i][j]++;
                    }
                }
            }
        }

        // Step 2: Initialize queue with indegree 0 cells
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (indegree[i][j] == 0) q.offer(new int[]{i, j});
            }
        }

        // Step 3: BFS Toposort
        int pathLength = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            pathLength++; // one level deeper = longer path
            for (int s = 0; s < size; s++) {
                int[] cell = q.poll();
                int i = cell[0], j = cell[1];
                for (int[] d : dirs) {
                    int ni = i + d[0], nj = j + d[1];
                    if (ni >= 0 && nj >= 0 && ni < m && nj < n && matrix[ni][nj] > matrix[i][j]) {
                        indegree[ni][nj]--;
                        if (indegree[ni][nj] == 0)
                            q.offer(new int[]{ni, nj});
                    }
                }
            }
        }
        return pathLength;
    }
}
