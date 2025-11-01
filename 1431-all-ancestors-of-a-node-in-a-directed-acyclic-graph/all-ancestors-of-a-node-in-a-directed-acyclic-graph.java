import java.util.*;

class Solution {
    TreeMap<Integer, List<Integer>> l = new TreeMap<>();

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        for (int i = 0; i < n; i++) l.put(i, new ArrayList<>());

        for (var s : edges) {
            l.get(s[1]).add(s[0]);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (var s : l.entrySet()) {
            List<Integer> am = s.getValue();
            HashSet<Integer> ans1 = new HashSet<>();
            helper(am, ans1);
            List<Integer> ll = new ArrayList<>(ans1);
            Collections.sort(ll);
            ans.add(ll);
        }
        return ans;
    }

    public void helper(List<Integer> am, HashSet<Integer> ans1) {
        for (int i = 0; i < am.size(); i++) {
            int parent = am.get(i);
            if (ans1.add(parent)) { // avoid duplicates
                helper(l.get(parent), ans1);
            }
        }
    }
}
