class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1){ return nums[0];}
        
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);

        if(n == 2) {return b;}

        int c = nums[1];
        int d = Math.max(nums[1], nums[2]);

        for(int i = 2; i<n - 1; i++){
            int temp = a + nums[i];
            a = b;
            b = Math.max(a, temp);
        }
        for(int i = 3; i<n; i++){
            int temp = c + nums[i];
            c = d;
            d = Math.max(c, temp);
        }

        return Math.max(b, d);
    }
}
