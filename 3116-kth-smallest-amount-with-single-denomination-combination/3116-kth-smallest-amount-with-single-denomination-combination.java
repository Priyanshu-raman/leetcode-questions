class Solution {
    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        List<Long> filteredCoins = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            boolean redundant = false;
            for (long c : filteredCoins) {
                if (coins[i] % c == 0) {
                    redundant = true;
                    break;
                }
            }
            if (!redundant) {
                filteredCoins.add((long) coins[i]);
            }
        }

        // Step 2: Binary search on the answer
        long low = 1;
        long high = filteredCoins.get(0) * (long) k;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (countMultiples(mid, filteredCoins) >= k) {
                ans = mid;
                high = mid - 1; // Try to find smaller valid amount
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Counts how many numbers <= X are divisible by at least one coin
    private long countMultiples(long x, List<Long> coins) {
        int n = coins.size();
        long totalCount = 0;

        // Iterate through all 2^n - 1 non-empty subsets
        for (int mask = 1; mask < (1 << n); mask++) {
            long currentLcm = 1;
            int bitCount = 0;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bitCount++;
                    currentLcm = lcm(currentLcm, coins.get(i));
                    if (currentLcm > x) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (!overflow) {
                if (bitCount % 2 == 1) {
                    totalCount += x / currentLcm;
                } else {
                    totalCount -= x / currentLcm;
                }
            }
        }

        return totalCount;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}