class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int l1, l2, r1, r2;
        int low = 0;
        int high = m;

        while(low <= high){
            int p1 = low + (high - low) / 2;
            int p2 = (m + n + 1) / 2 - p1;

            l1 = (p1 == 0)? Integer.MIN_VALUE : nums1[p1 - 1];
            r1 = (p1 == m)? Integer.MAX_VALUE : nums1[p1];

            l2 = (p2 == 0)? Integer.MIN_VALUE : nums2[p2 - 1];
            r2 = (p2 == n)? Integer.MAX_VALUE : nums2[p2];

            if(l1 <= r2 && l2 <= r1){
                //Find median
                if( (m + n) % 2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else{
                    return (Math.max(l1, l2));
                }
            } else if(l1 > r2){
                high = p1 - 1;
            } else{
                low = p1 + 1;
            }
        }

        return -1;
    }
}