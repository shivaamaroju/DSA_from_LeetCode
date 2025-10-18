class Solution {
    int max = -1; 
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean vis[] = new boolean[n];
        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        int in[] = new int[n];

      
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] == -1) continue;
            mp.computeIfAbsent(i, k -> new ArrayList<>()).add(edges[i]);
            in[edges[i]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (in[i] == 0) {
            vis[i] = true;
            q.add(i);
        }

        while (!q.isEmpty()) {
            int x = q.remove();
            if (!mp.containsKey(x)) continue;
            for (int s : mp.get(x)) {
                in[s]--;
                if (in[s] == 0) {
                    q.add(s);
                    vis[s] = true;
                }
            }
        }

        
        List<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) if (!vis[i]) nodes.add(i);


        for (int i : nodes) {
            if (vis[i]) continue;
            findCycle(i, edges, vis);
        }

        return max;
    }


public void findCycle(int start,int e[],boolean vis[]){
    int steps=0;
HashMap<Integer,Integer> mp=new HashMap<>();
while(start!=-1&&!vis[start]){
    steps++;
    vis[start]=true;
    mp.put(start,steps);
    start=e[start];
    if(start!=-1&&mp.containsKey(start)){
        max=Math.max(steps,max);
    }
}
}
}
