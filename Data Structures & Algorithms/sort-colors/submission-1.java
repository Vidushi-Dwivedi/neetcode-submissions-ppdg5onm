class Solution {
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void sortColors(int[] nums) {
        int i = -1;
        int j = nums.length - 1;
        int k = 0;

        while(k <= j){
            if(nums[k] == 0){
                i++;
                swap(nums, i, k);
                k++;
            } else if(nums[k] == 2){
                swap(nums, k, j);
                j--;
            } else{
                k++;
            }
        }
    }
}