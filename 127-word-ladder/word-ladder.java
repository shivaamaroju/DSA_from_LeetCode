class Solution {
    public int ladderLength(String b, String e, List<String> wordList) {
        HashSet<String> hs = new HashSet<>(wordList);
        if (!hs.contains(e)) return 0; // end word must be in wordList

        HashSet<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int c = 1; // start from 1 because beginWord is counted
        q.add(b);
        vis.add(b);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                String x = q.remove();
                char[] ch = x.toCharArray();

                for (int j = 0; j < ch.length; j++) {
                    char or = ch[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == or) continue; // skip same character
                        ch[j] = k;
                        String kotha = new String(ch);

                        if (kotha.equals(e)) return c + 1;

                        if (!vis.contains(kotha) && hs.contains(kotha)) {
                            q.add(kotha);
                            vis.add(kotha);
                        }
                    }
                    ch[j] = or;
                }
            }
            c++;
        }
        return 0;
    }
}
