class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int max_area = 0;

        for(int i = 0; i<= n; i++){
            int cur = (i == n)? 0 : heights[i];

            while(!st.isEmpty() && heights[st.peek()] > cur){
                int hei = heights[st.pop()];
                int width = (st.isEmpty())? i : (i - st.peek() - 1);
                int area = hei * width;
                max_area = Math.max(max_area, area);
            }  

            st.push(i);
        }    

        return max_area;
    }
}
