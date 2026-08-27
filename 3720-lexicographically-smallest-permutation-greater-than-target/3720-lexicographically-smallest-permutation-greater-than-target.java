class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Step 1: Match target character-by-character as far as possible
        int matchLen = 0;
        while (matchLen < n && count[target.charAt(matchLen) - 'a'] > 0) {
            count[target.charAt(matchLen) - 'a']--;
            matchLen++;
        }

        // Step 2: Backtrack from matchLen down to 0 to find the earliest valid divergence point
        for (int i = matchLen; i >= 0; i--) {
            if (i < n) {
                char targetChar = target.charAt(i);

                // Find the smallest available character strictly greater than target[i]
                for (int c = targetChar - 'a' + 1; c < 26; c++) {
                    if (count[c] > 0) {
                        StringBuilder sb = new StringBuilder();

                        // 1. Matched prefix up to i - 1
                        sb.append(target, 0, i);

                        // 2. The strictly greater character at position i
                        sb.append((char) ('a' + c));
                        count[c]--;

                        // 3. Append remaining available characters in sorted ascending order
                        for (int remainingChar = 0; remainingChar < 26; remainingChar++) {
                            while (count[remainingChar] > 0) {
                                sb.append((char) ('a' + remainingChar));
                                count[remainingChar]--;
                            }
                        }

                        return sb.toString();
                    }
                }
            }

            // Backtrack: reclaim character target[i - 1]
            if (i > 0) {
                count[target.charAt(i - 1) - 'a']++;
            }
        }

        return "";
    }
}