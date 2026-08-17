class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        int[][] memo = new int[n][n];
        return solve(0, n - 1, prefix, memo);
    }

    private int solve(int i, int j, int[] prefix, int[][] memo) {
        // Base case: Single stone left -> 0 points
        if (i == j) {
            return 0;
        }

        // Return memoized result
        if (memo[i][j] > 0) {
            return memo[i][j];
        }

        int maxScore = 0;

        // Try all partition points k
        for (int k = i; k < j; k++) {
            int leftSum = prefix[k + 1] - prefix[i];
            int rightSum = prefix[j + 1] - prefix[k + 1];

            if (leftSum < rightSum) {
                maxScore = Math.max(maxScore, leftSum + solve(i, k, prefix, memo));
            } else if (rightSum < leftSum) {
                maxScore = Math.max(maxScore, rightSum + solve(k + 1, j, prefix, memo));
            } else {
                // If equal, Alice chooses the side giving maximum total score
                int keepLeft = leftSum + solve(i, k, prefix, memo);
                int keepRight = rightSum + solve(k + 1, j, prefix, memo);
                maxScore = Math.max(maxScore, Math.max(keepLeft, keepRight));
            }
        }

        memo[i][j] = maxScore;
        return maxScore;
    }
}