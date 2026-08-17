class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int[] ans = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int right = 0; right < nums.length; right++){
            if(right - left + 1 > k){
                ans[left] = pq.peek();
                pq.remove(nums[left]);
                left++;
            }

            pq.offer(nums[right]);
        }

        ans[left] = pq.peek();

        return ans;
    }
}
