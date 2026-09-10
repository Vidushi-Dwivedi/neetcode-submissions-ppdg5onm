class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length; // Visual boundary of valid elements
        
        while (i < j) {
            if (nums[i] == val) {
                // Overwrite current element with the last element
                nums[i] = nums[j - 1];
                // Reduce the active size of the array
                j--;
            } else {
                // Only move forward if the current element is valid
                i++;
            }
        }
        
        return j;
    }
}