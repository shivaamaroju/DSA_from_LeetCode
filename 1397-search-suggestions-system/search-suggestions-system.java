class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> outer = new ArrayList<>();
        Trie trie = new Trie();
        for (var i : products)
            trie.insert(i);
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> inner = trie.search(searchWord.substring(0, i + 1));
            outer.add(inner);
        }
        return outer;
    }
}

class Node {
    Node a[] = new Node[26];
    boolean ew = false;
}

class Trie {
    Node root = new Node();

    void insert(String s) {
        Node temp = root;
        for (var i : s.toCharArray()) {
            int idx = i - 'a';
            if (temp.a[idx] == null)
                temp.a[idx] = new Node();
            temp = temp.a[idx];
        }
        temp.ew = true;
    }

    List<String> search(String prefix) {
        Node temp = root;
        List<String> res = new ArrayList<>();
        for (var i : prefix.toCharArray()) {
            int idx = i - 'a';
            if (temp.a[idx] == null)
                return res;
            temp = temp.a[idx];
        }
        return dfs(temp, res, prefix);

    }

    List<String> dfs(Node temp, List<String> res, String word) {
        if (res.size() == 3)
            return res;
        if (temp.ew)
            res.add(word);
        for (int i = 0; i < 26; i++) {
            if (temp.a[i] != null)
                dfs(temp.a[i], res, word + (char) ('a' + i));
        }
        return res;
    }
}
