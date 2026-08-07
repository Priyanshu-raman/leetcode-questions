// import java.util.Arrays;

class Solution {
    private static final int[] F2 = {0, 0, 1, 0, 2, 0, 1, 0, 3, 0};
    private static final int[] F3 = {0, 0, 0, 1, 0, 0, 1, 0, 0, 2};
    private static final int[] F5 = {0, 0, 0, 0, 0, 1, 0, 0, 0, 0};
    private static final int[] F7 = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};

    public String smallestNumber(String num, long t) {
        // Step 1: Factorize t into prime factors 2, 3, 5, 7
        int c2 = 0, c3 = 0, c5 = 0, c7 = 0;
        while (t % 2 == 0) { c2++; t /= 2; }
        while (t % 3 == 0) { c3++; t /= 3; }
        while (t % 5 == 0) { c5++; t /= 5; }
        while (t % 7 == 0) { c7++; t /= 7; }

        if (t > 1) {
            return "-1"; // Invalid prime factors (> 7)
        }

        int n = num.length();

        // Step 2: Check if num itself is valid
        int zeroIdx = num.indexOf('0');
        if (zeroIdx == -1) {
            int p2 = 0, p3 = 0, p5 = 0, p7 = 0;
            for (int i = 0; i < n; i++) {
                int d = num.charAt(i) - '0';
                p2 += F2[d]; p3 += F3[d]; p5 += F5[d]; p7 += F7[d];
            }
            if (p2 >= c2 && p3 >= c3 && p5 >= c5 && p7 >= c7) {
                return num; // num satisfies all requirements
            }
        }

        // Step 3: Compute prefix prime factor sums
        int limit = (zeroIdx == -1) ? n : zeroIdx;
        int[] pref2 = new int[limit + 1];
        int[] pref3 = new int[limit + 1];
        int[] pref5 = new int[limit + 1];
        int[] pref7 = new int[limit + 1];

        for (int i = 0; i < limit; i++) {
            int d = num.charAt(i) - '0';
            pref2[i + 1] = pref2[i] + F2[d];
            pref3[i + 1] = pref3[i] + F3[d];
            pref5[i + 1] = pref5[i] + F5[d];
            pref7[i + 1] = pref7[i] + F7[d];
        }

        // FIX: Start at zeroIdx directly if zero exists, otherwise n - 1
        int startI = (zeroIdx == -1) ? n - 1 : zeroIdx;

        // Step 4: Try to match prefix up to index i-1 and change digit at index i
        for (int i = startI; i >= 0; i--) {
            int rem2 = Math.max(0, c2 - pref2[i]);
            int rem3 = Math.max(0, c3 - pref3[i]);
            int rem5 = Math.max(0, c5 - pref5[i]);
            int rem7 = Math.max(0, c7 - pref7[i]);

            int startDigit = num.charAt(i) - '0' + 1;
            for (int d = startDigit; d <= 9; d++) {
                int nr2 = Math.max(0, rem2 - F2[d]);
                int nr3 = Math.max(0, rem3 - F3[d]);
                int nr5 = Math.max(0, rem5 - F5[d]);
                int nr7 = Math.max(0, rem7 - F7[d]);

                int reqLen = minLen(nr2, nr3, nr5, nr7);
                if (reqLen <= n - 1 - i) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append(d);
                    fillSuffix(sb, n - 1 - i, nr2, nr3, nr5, nr7);
                    return sb.toString();
                }
            }
        }

        // Step 5: If no answer of length n exists, construct length > n
        int targetLen = Math.max(n + 1, minLen(c2, c3, c5, c7));
        StringBuilder sb = new StringBuilder();
        fillSuffix(sb, targetLen, c2, c3, c5, c7);
        return sb.toString();
    }

    private int minLen(int c2, int c3, int c5, int c7) {
        int count = c5 + c7;
        count += c2 / 3; // 8s
        count += c3 / 2; // 9s

        int r2 = c2 % 3;
        int r3 = c3 % 2;

        if (r2 == 2 && r3 == 1) {
            count += 2; // 4 and 3
        } else if (r2 > 0 || r3 > 0) {
            count += 1; // 2, 3, 4, or 6
        }

        return count;
    }

    private void fillSuffix(StringBuilder sb, int len, int r2, int r3, int r5, int r7) {
        for (int pos = 0; pos < len; pos++) {
            int remPositions = len - 1 - pos;
            for (int d = 1; d <= 9; d++) {
                int nr2 = Math.max(0, r2 - F2[d]);
                int nr3 = Math.max(0, r3 - F3[d]);
                int nr5 = Math.max(0, r5 - F5[d]);
                int nr7 = Math.max(0, r7 - F7[d]);

                if (minLen(nr2, nr3, nr5, nr7) <= remPositions) {
                    sb.append(d);
                    r2 = nr2; r3 = nr3; r5 = nr5; r7 = nr7;
                    break;
                }
            }
        }
    }
}