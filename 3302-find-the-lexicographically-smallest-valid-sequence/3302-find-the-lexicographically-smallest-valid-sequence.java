

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // last[j] stores the largest index in word1 to match word2[j...m-1] exactly
        int[] last = new int[m + 1];
        Arrays.fill(last, -1);
        last[m] = n; // Base case: empty suffix can start at index n

        // Step 1: Precompute last array from right to left
        int p = n - 1;
        for (int j = m - 1; j >= 0; j--) {
            while (p >= 0 && word1.charAt(p) != word2.charAt(j)) {
                p--;
            }
            last[j] = p;
            if (p >= 0) {
                p--; // Move to next available character for preceding match
            }
        }

        // Step 2: Greedy matching from left to right
        int[] ans = new int[m];
        boolean changed = false;
        int j = 0;

        for (int i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j++] = i;
            } else if (!changed && i < last[j + 1]) {
                // Use our 1 allowed mismatch
                changed = true;
                ans[j++] = i;
            }
        }

        // Return answer if all characters of word2 were matched
        return j == m ? ans : new int[0];
    }
}