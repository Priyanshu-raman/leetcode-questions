class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        // endWith[i] stores the total distinct subsequences ending with character ('a' + i)
        long[] endWith = new long[26];
        long total = 0;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            // New subsequences formed ending with ch:
            // (all existing subsequences + 1 for standalone ch) - previous count of ch
            long newCount = (total + 1 - endWith[idx] + MOD) % MOD;
            
            total = (total + newCount) % MOD;
            endWith[idx] = (endWith[idx] + newCount) % MOD;
        }

        return (int) total;
    }
}