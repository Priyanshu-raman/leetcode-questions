class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Validate palindrome condition
        int oddCount = 0;
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
        }

        if ((n % 2 == 0 && oddCount > 0) || (n % 2 == 1 && oddCount != 1)) {
            return "";
        }

        // Half frequencies
        int m = n / 2;
        int[] halfCount = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        // Step 1: Try to match target[0...m-1] as far as possible
        int matchLen = 0;
        while (matchLen < m && halfCount[target.charAt(matchLen) - 'a'] > 0) {
            halfCount[target.charAt(matchLen) - 'a']--;
            matchLen++;
        }

        // Step 2: Check if exact match of first half produces a valid palindrome > target
        if (matchLen == m) {
            String cand = buildPalindrome(target.substring(0, m), midChar, n % 2 != 0);
            if (cand.compareTo(target) > 0) {
                return cand;
            }
        }

        // Step 3: Backtrack from matchLen down to 0 to find divergence point
        for (int i = matchLen; i >= 0; i--) {
            if (i < m) {
                char targetChar = target.charAt(i);

                // Find smallest available character > target[i]
                for (int c = targetChar - 'a' + 1; c < 26; c++) {
                    if (halfCount[c] > 0) {
                        StringBuilder firstHalf = new StringBuilder();
                        firstHalf.append(target, 0, i);
                        firstHalf.append((char) ('a' + c));
                        halfCount[c]--;

                        // Fill remaining slots of first half in ascending order
                        for (int remaining = 0; remaining < 26; remaining++) {
                            while (halfCount[remaining] > 0) {
                                firstHalf.append((char) ('a' + remaining));
                                halfCount[remaining]--;
                            }
                        }

                        return buildPalindrome(firstHalf.toString(), midChar, n % 2 != 0);
                    }
                }
            }

            // Backtrack: reclaim character target[i - 1]
            if (i > 0) {
                halfCount[target.charAt(i - 1) - 'a']++;
            }
        }

        return "";
    }

    private String buildPalindrome(String firstHalf, char midChar, boolean hasOdd) {
        StringBuilder sb = new StringBuilder(firstHalf);
        if (hasOdd) {
            sb.append(midChar);
        }
        for (int i = firstHalf.length() - 1; i >= 0; i--) {
            sb.append(firstHalf.charAt(i));
        }
        return sb.toString();
    }
}