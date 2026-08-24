class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        // Step 1: Compute prefix sums in-place
        int[] prefixSum = new int[n];
        prefixSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }

        // Step 2: Backward DP
        // Base case: at the last index, the player must take prefixSum[n - 1]
        int dp = prefixSum[n - 1];

        // Transition from n - 2 down to 1
        for (int i = n - 2; i >= 1; i--) {
            dp = Math.max(dp, prefixSum[i] - dp);
        }

        return dp;
    }
}