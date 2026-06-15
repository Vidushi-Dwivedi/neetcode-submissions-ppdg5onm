class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (low + high)/ 2;
            
            if(nums[mid] == target){
                return mid;
            } else if((target >= nums[low] && target < nums[mid]) ||
                        (nums[mid] < nums[low] && (target >= nums[low] || target < nums[mid]))){
                            System.out.println("1: " + low + "  " + high + "  " + mid);
                            high = mid - 1;
            }
            else{
                System.out.println("2: " + low + "  " + high + "  " + mid);

                low = mid + 1;
            }
        }

        return -1;
    }
}