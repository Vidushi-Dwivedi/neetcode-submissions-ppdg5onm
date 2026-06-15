class Solution {
    public void reverse(int[] nums, int i, int j){
        if(i < 0 || j < 0 || i > nums.length - 1 || j > nums.length-1){
            return;
        }
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public void rotate(int[] nums, int k) {
        int size = nums.length;

        reverse(nums, 0, size-1);
        k = k % size;
        reverse(nums, 0, k - 1);
        reverse(nums, k, size - 1);
    }
}