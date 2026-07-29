import java.util.*;

class Solution {
    private static final long MAX_K = 1_000_001L;

    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] halfCount = new int[26];
        char midChar = 0;

        // Count frequency of each character
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Divide frequencies by 2 for the left half
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
            if (count[i] % 2 != 0) {
                midChar = (char) ('a' + i);
            }
        }

        // Total permutations possible for the left half
        long totalPermutations = countArrangements(halfCount);
        if (k > totalPermutations) {
            return "";
        }

        // Construct the left half character by character
        int halfLen = n / 2;
        StringBuilder leftHalf = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int i = 0; i < 26; i++) {
                if (halfCount[i] == 0) continue;

                // Try picking character 'a' + i
                halfCount[i]--;
                long arrangements = countArrangements(halfCount);

                if (arrangements >= k) {
                    leftHalf.append((char) ('a' + i));
                    break; // Keep this character choice
                } else {
                    k -= arrangements;
                    halfCount[i]++; // Backtrack and try next character
                }
            }
        }

        // Construct full palindrome: leftHalf + midChar (if any) + reversed(leftHalf)
        String left = leftHalf.toString();
        String right = leftHalf.reverse().toString();

        return left + (midChar == 0 ? "" : midChar) + right;
    }

    // Calculates multinomial coefficient: n! / (n1! * n2! * ... * nr!)
    private long countArrangements(int[] count) {
        int total = 0;
        for (int c : count) {
            total += c;
        }

        long res = 1;
        for (int freq : count) {
            res *= nCk(total, freq);
            if (res >= MAX_K) return MAX_K; // Cap to prevent overflow
            total -= freq;
        }
        return res;
    }

    // Combinations n Choose k
    private long nCk(int n, int k) {
        k = Math.min(k, n - k);
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
            if (res >= MAX_K) return MAX_K;
        }
        return res;
    }
}