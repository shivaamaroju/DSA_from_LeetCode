class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] e) {
        if (n == 1) return List.of(0); // edge case
        
        int in[] = new int[n];
        HashMap<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < e.length; i++) {
            int u = e[i][0];
            int v = e[i][1];
            in[u]++;
            in[v]++;
            mp.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            mp.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (in[i] == 1) q.add(i);

        // Trim leaves layer by layer until 2 or fewer nodes remain
        int remaining = n;
        while (remaining > 2) {
            int size = q.size();
            remaining -= size; // remove current leaves
            for (int i = 0; i < size; i++) {
                int x = q.remove();
                for (int nei : mp.get(x)) {
                    in[nei]--;
                    if (in[nei] == 1)
                        q.add(nei);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) ans.add(q.remove());
        return ans;
    }
}
