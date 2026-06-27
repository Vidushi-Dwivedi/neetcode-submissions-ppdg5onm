
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;

        // Shrink the window from the outside in until it is exactly size k
        while (r - l + 1 > k) {
            // If the left element is closer or equidistant, it's preferred over the right element
            if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                r--; // Right is further away, discard it
            } else {
                l++; // Left is further away, discard it
            }
        }

        // Build the final result list from the stable indices
        List<Integer> result = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
