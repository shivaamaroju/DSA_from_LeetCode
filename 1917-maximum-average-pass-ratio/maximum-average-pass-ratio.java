class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // PriorityQueue based on the gain of adding one passing student
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            double gain1 = ((double)(x[0] + 1) / (x[1] + 1)) - ((double)x[0] / x[1]);
            double gain2 = ((double)(y[0] + 1) / (y[1] + 1)) - ((double)y[0] / y[1]);
            return Double.compare(gain2, gain1); // max-heap behavior
        });

        for (int[] c : classes) {
            pq.add(c);
        }

        // Assign extra students greedily
        while (extraStudents-- > 0) {
            int[] top = pq.poll();
            top[0]++; // add one pass
            top[1]++; // add one student
            pq.add(top);
        }

        // Calculate average ratio
        double sum = 0.0;
        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            sum += (double)a[0] / a[1];
        }

        return sum / classes.length;
    }
}
