class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0; // No primes strictly less than 2
        }

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        // Mark composite numbers up to sqrt(n)
        for (int p = 2; p * p < n; p++) {
            if (isPrime[p]) {
                // Start marking from p * p
                for (int i = p * p; i < n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // Count remaining prime numbers
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}