import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        path.add(0); // start from node 0
        helper(0, graph.length - 1, graph, path);
        return ans;
    }

    public void helper(int src, int target, int[][] graph, List<Integer> path) {
        if (src == target) {
            ans.add(new ArrayList<>(path)); // store a copy of the current path
            return;
        }

        for (int next : graph[src]) {
            path.add(next);
            helper(next, target, graph, path);
            path.remove(path.size() - 1); // backtrack
        }
    }
}

