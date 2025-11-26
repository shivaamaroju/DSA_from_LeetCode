class Solution {
    static class TrieNode {
        Map<Character, TrieNode> next = new HashMap<>();
        int bestLen = 0; // store maximum length ending here
    }

    public int maxProduct(String[] words) {
        TrieNode root = new TrieNode();
        int best = 0;

        // BUILD TRIE
        for (String word : words) {
            TrieNode node = root;

            // unique sorted characters
            Set<Character> set = new HashSet<>();
            for (char c : word.toCharArray()) set.add(c);

            List<Character> list = new ArrayList<>(set);
            Collections.sort(list);

            for (char c : list) {
                node.next.putIfAbsent(c, new TrieNode());
                node = node.next.get(c);
            }

            // store max length here
            node.bestLen = Math.max(node.bestLen, word.length());
        }

        // FIND ANSWER
        for (String word : words) {
            Set<Character> letters = new HashSet<>();
            for (char c : word.toCharArray()) letters.add(c);

            Queue<TrieNode> q = new ArrayDeque<>();
            q.add(root);

            while (!q.isEmpty()) {
                TrieNode node = q.poll();

                // if this is an end position with best length
                if (node.bestLen > 0) {
                    best = Math.max(best, node.bestLen * word.length());
                }

                // BFS move through neighbors
                for (Map.Entry<Character, TrieNode> entry : node.next.entrySet()) {
                    char c = entry.getKey();
                    if (!letters.contains(c)) {
                        q.add(entry.getValue());
                    }
                }
            }
        }

        return best;
    }
}
