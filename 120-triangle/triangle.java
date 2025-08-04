class Solution {
    public int minimumTotal(List<List<Integer>> l) {
        for (int i = l.size() - 2; i >= 0; i--) {
            for (int j = 0; j < l.get(i).size(); j++) {
                int min = Math.min(
                    l.get(i + 1).get(j),
                    l.get(i + 1).get(j + 1)
                );
                l.get(i).set(j, l.get(i).get(j) + min);
            }
        }
        return l.get(0).get(0);
    }
}
