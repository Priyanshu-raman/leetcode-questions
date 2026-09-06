class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // dp[j] stores the number of ways to form t[0...j-1]
        // Using double/long can prevent overflow during intermediate additions,
        // but standard integer fits per problem constraints.
        int[] dp = new int[n + 1];

        // Base case: 1 way to form an empty string t
        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            char sChar = s.charAt(i - 1);
            // Iterate backwards to use values from the previous row
            for (int j = n; j >= 1; j--) {
                if (sChar == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n];
    }
}