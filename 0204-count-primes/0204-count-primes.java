public class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        
        // We only track odd numbers: 3, 5, 7, 9, ...
        // Size required is roughly n / 2
        int HALF = n / 2;
        boolean[] isComposite = new boolean[HALF];
        
        // Count starts at 1 to include prime number '2'
        int count = 1; 

        int sqrtN = (int) Math.sqrt(n);
        
        // i represents odd numbers (2*i + 1)
        for (int i = 1; 2 * i + 1 < n; i++) {
            if (!isComposite[i]) {
                count++;
                int prime = 2 * i + 1;
                
                // Mark multiples of this odd prime starting from prime^2
                if (prime <= sqrtN) {
                    for (int j = 2 * i * (i + 1); j < HALF; j += prime) {
                        isComposite[j] = true;
                    }
                }
            }
        }
        
        return count;
    }
}