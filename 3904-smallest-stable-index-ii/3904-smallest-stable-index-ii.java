class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Precompute suffix minimums
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        // Step 2: Iterate and check stability
        int runningMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            runningMax = Math.max(runningMax, nums[i]);
            if (runningMax - suffixMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}