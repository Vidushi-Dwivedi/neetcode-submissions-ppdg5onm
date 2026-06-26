class Solution {
    public int trap(int[] height) {
        int l = height.length;
        int max = 0;
        int ans = 0;
        int[] left = new int[l];
        int[] right = new int[l];

        for(int i = 1; i< l; i++){
            left[i] = Math.max(height[i-1], left[i-1]);
        }

        for(int i = l-2; i >= 0; i--){
            right[i] = Math.max(height[i + 1], right[i+1]);
        }

        for(int i = 0; i<l; i++){
            int cur = Math.min(left[i], right[i]) - height[i];
            ans = ans + ((cur>0)?cur: 0);
        }

        return ans;
    }
}
