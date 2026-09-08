class Solution {
    public int countCommas(int n) {
        if (n < 1000) return 0;

        int totalCommas = 0;
        long threshold = 1000;

        while (n >= threshold) {
            // Count all numbers from threshold up to n
            totalCommas += (n - threshold + 1);
            threshold *= 1000;
        }

        return totalCommas;
    }
}