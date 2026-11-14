class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;
        
        // Iterate through all valid window sizes from l to r
        for (int windowSize = l; windowSize <= r; ++windowSize) {
            int sum = 0;
            
            // Compute the sum of the first window of size 'windowSize'
            for (int i = 0; i < windowSize; ++i) {
                sum += nums.get(i);
            }
            if (sum > 0) {
                ans = Math.min(ans, sum);
            }
            
            // Slide the window across the rest of the array
            for (int i = windowSize; i < n; ++i) {
                sum -= nums.get(i - windowSize);
                sum += nums.get(i);
                if (sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }
        
        // Return minimum sum or -1 if no valid subarray exists
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}