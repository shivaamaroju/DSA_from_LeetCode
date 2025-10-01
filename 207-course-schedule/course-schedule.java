class Solution {
    public boolean canFinish(int n, int[][] p) {
        int[] indegree = new int[n];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        // build graph correctly: b -> a
        for (int i = 0; i < p.length; i++) {
            graph.computeIfAbsent(p[i][1], k -> new ArrayList<>()).add(p[i][0]);
            indegree[p[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int course = q.remove();
            count++;
            if (graph.containsKey(course)) {
                for (int next : graph.get(course)) {
                    indegree[next]--;
                    if (indegree[next] == 0) q.add(next);
                }
            }
        }

        return count == n;
    }
}
