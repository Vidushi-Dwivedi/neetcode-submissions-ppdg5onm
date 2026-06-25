class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length -1;
        int max = Integer.MIN_VALUE;

        while(left < right){
            int area = 0;
            int length = (right - left);
            if(heights[left] < heights[right]){
                area = length * heights[left];
                left++;
            } else{
                area = length * heights[right];
                right--;
            }

            max = Math.max(area, max);
        }

        return max;
    }
}
