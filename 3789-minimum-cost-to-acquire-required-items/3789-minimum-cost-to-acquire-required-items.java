class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long strategy1 = (long) need1 * cost1 + (long) need2 * cost2;
        
        // Strategy 2: Buy only type 3 items to cover the maximum requirement
        long strategy2 = (long) costBoth * Math.max(need1, need2);
        
        // Strategy 3: Buy min(need1, need2) type 3 items, then cover remaining needs
        int minNeed = Math.min(need1, need2);
        long strategy3 = (long) costBoth * minNeed + 
                         (long) (need1 - minNeed) * cost1 + 
                         (long) (need2 - minNeed) * cost2;
        
        // Return the minimum cost among all three strategies
        return Math.min(strategy1, Math.min(strategy2, strategy3));
    }
}