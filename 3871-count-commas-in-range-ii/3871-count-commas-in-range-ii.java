class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;
        long threshold = 1000;

        while (n >= threshold) {
            totalCommas += (n - threshold + 1);
            
            // Prevent 64-bit signed integer overflow when multiplying by 1000
            if (threshold > Long.MAX_VALUE / 1000) {
                break;
            }
            threshold *= 1000;
        }

        return totalCommas;
    }
}