import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Map<Integer, List<Integer>> reverseGraph = new HashMap<>();
        int[] indegree = new int[n];

        // Build reversed graph and indegree count
        for (int i = 0; i < n; i++) {
            for (int nei : graph[i]) {
                reverseGraph.computeIfAbsent(nei, k -> new ArrayList<>()).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        // Start BFS with all terminal nodes (nodes with no outgoing edges)
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        boolean[] safe = new boolean[n];

        while (!queue.isEmpty()) {
            int node = queue.poll();
            safe[node] = true;

            if (reverseGraph.containsKey(node)) {
                for (int prev : reverseGraph.get(node)) {
                    indegree[prev]--;
                    if (indegree[prev] == 0) {
                        queue.offer(prev);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) result.add(i);
        }

        return result;
    }
}
