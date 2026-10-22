class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        // Check increasing order to the right (step = 1)
        if (isValid(nums, zero, 1)) {
            ans = Math.min(ans, zero);
            ans = Math.min(ans, n - zero + 2);
        }
        
        // Check increasing order to the left (step = -1)
        if (isValid(nums, zero, -1)) {
            ans = Math.min(ans, zero + 2);
            ans = Math.min(ans, n - zero);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private boolean isValid(int[] nums, int zero, int step) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int prev = (zero + (i - 1) * step) % n;
            if (prev < 0) prev += n;
            int curr = (zero + i * step) % n;
            if (curr < 0) curr += n;
            if (nums[prev] > nums[curr]) {
                return false;
            }
        }
        return true;
    }
}