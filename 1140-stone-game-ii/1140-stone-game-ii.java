class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        
        // Compute suffix sums: suffixSum[i] = total stones from pile i to end
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        // memo[i][M] stores max stones the current player can get 
        // starting at index i with current parameter M
        int[][] memo = new int[n][n + 1];

        return dp(0, 1, piles, suffixSum, memo);
    }

    private int dp(int i, int M, int[] piles, int[] suffixSum, int[][] memo) {
        int n = piles.length;

        // Base case: If current player can take all remaining piles
        if (i + 2 * M >= n) {
            return suffixSum[i];
        }

        // Return cached result if available
        if (memo[i][M] > 0) {
            return memo[i][M];
        }

        int maxStones = 0;

        // Try taking X piles where 1 <= X <= 2 * M
        for (int X = 1; X <= 2 * M; X++) {
            int nextM = Math.max(M, X);
            
            // Current player's score = Total remaining - Opponent's optimal score
            int currentStones = suffixSum[i] - dp(i + X, nextM, piles, suffixSum, memo);
            maxStones = Math.max(maxStones, currentStones);
        }

        memo[i][M] = maxStones;
        return maxStones;
    }
}