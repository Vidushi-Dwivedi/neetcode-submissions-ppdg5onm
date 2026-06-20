class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int y : asteroids) {
            boolean yExploded = false;

            // FIXED: Only collide if stack top goes RIGHT (positive) 
            // and incoming 'y' goes LEFT (negative)
            while (!st.isEmpty() && st.peek() > 0 && y < 0) {
                int x = st.peek();

                if (Math.abs(x) < Math.abs(y)) {
                    st.pop(); // x is smaller, destroy it from stack and continue loop
                } else if (Math.abs(x) == Math.abs(y)) {
                    st.pop(); // Both are equal, destroy x from stack
                    yExploded = true; // Mark y as destroyed
                    break;    // Stop checking
                } else {
                    yExploded = true; // x is bigger, y explodes
                    break;    // Stop checking
                }
            }

            // Only push y if it survived all possible collisions
            if (!yExploded) {
                st.push(y);
            }
        }

        // Convert stack back to array efficiently
        int[] ans = new int[st.size()];
        int idx = st.size() - 1;
        while (!st.isEmpty()) {
            ans[idx--] = st.pop();
        }

        return ans;
    }
}