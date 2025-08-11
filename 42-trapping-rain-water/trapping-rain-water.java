import java.util.*;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] psg = new int[n]; // Previous greater (max on left)
        int[] nsg = new int[n]; // Next greater (max on right)

        Stack<Integer> st = new Stack<>();

        // PSG: Loop from last to first
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && height[st.peek()] <= height[i]) {
                st.pop();
            }
            if (st.isEmpty()) psg[i] = height[i];
            else psg[i] = Math.max(height[i], psg[st.peek()]);
            st.push(i);
        }

        st.clear();

        // NSG: Loop from first to last
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && height[st.peek()] <= height[i]) {
                st.pop();
            }
            if (st.isEmpty()) nsg[i] = height[i];
            else nsg[i] = Math.max(height[i], nsg[st.peek()]);
            st.push(i);
        }

        // Calculate trapped water
        int water = 0;
        for (int i = 0; i < n; i++) {
            int trapped = Math.min(psg[i], nsg[i]) - height[i];
            if (trapped > 0) water += trapped;
        }

        return water;
    }
}
