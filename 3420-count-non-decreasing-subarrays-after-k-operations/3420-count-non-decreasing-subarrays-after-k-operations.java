class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        long ans = 0;
        long cost = 0;
        // Store indices of `nums` with `nums[i]` in non-increasing order.
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = nums.length - 1, j = nums.length - 1; i >= 0; --i) {
            final int num = nums[i];
            
            // Maintain monotonic stack property
            while (!dq.isEmpty() && nums[dq.peekLast()] < num) {
                int l = dq.pollLast();
                int r = dq.isEmpty() ? j + 1 : dq.peekLast();
                cost += (long) (r - l) * (num - nums[l]);
            }
            dq.offerLast(i);
            
            // Shrink the window from the right if cost exceeds k
            while (cost > k) {
                cost -= nums[dq.peekFirst()] - nums[j];
                if (dq.peekFirst() == j) {
                    dq.pollFirst();
                }
                --j;
            }
            
            // Add the count of valid subarrays starting at i
            ans += j - i + 1;
        }
        
        return ans;
    }
}