class Solution {
    public int climbStairs(int n, int[] costs) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == Long.MAX_VALUE) continue;
            
            // Can jump 1, 2, or 3 steps forward
            for (int step = 1; step <= 3; step++) {
                int j = i + step;
                if (j <= n) {
                    long cost = dp[i] + costs[j - 1] + (long) step * step;
                    dp[j] = Math.min(dp[j], cost);
                }
            }
        }
        
        return (int) dp[n];
    }
}