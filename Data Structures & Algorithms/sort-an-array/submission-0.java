class Solution {
    public int partition(int[] nums, int low, int high){
        int pivot_value = nums[high];
        int i = low - 1;

        for(int j = low; j< high; j++){
            if(nums[j] < pivot_value){
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }

        int temp = nums[i + 1];
        nums[i + 1] = pivot_value;
        nums[high] = temp;

        return i + 1;
    }

    public void quickSort(int[] nums, int low, int high){
        if(low < high){
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
}