class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        // Fill DP table from 1 to n
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k * k <= i; k++) {
                // If taking k*k stones leaves the opponent in a losing state
                if (!dp[i - k * k]) {
                    dp[i] = true;
                    break; // Winning move found, no need to check further k
                }
            }
        }

        return dp[n];
    }
}