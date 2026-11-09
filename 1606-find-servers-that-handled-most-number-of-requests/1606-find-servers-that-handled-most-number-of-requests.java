class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count = new int[k];
        
        // TreeSet to store available server IDs in sorted order
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            free.add(i);
        }
        
        // Min-Heap to store busy servers: [freeTime, serverId]
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < arrival.length; i++) {
            int time = arrival[i];
            int duration = load[i];
            
            // 1. Release servers that have finished processing before/at current arrival time
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                free.add(busy.poll()[1]);
            }
            
            // 2. If no servers are free, drop the request
            if (free.isEmpty()) {
                continue;
            }
            
            // 3. Find target server starting from (i % k)
            int target = i % k;
            Integer assigned = free.ceiling(target);
            if (assigned == null) {
                assigned = free.first(); // Wrap around to the smallest available server
            }
            
            // 4. Assign the request
            count[assigned]++;
            free.remove(assigned);
            busy.offer(new int[]{time + duration, assigned});
        }
        
        // Find max requests handled by any server
        int maxRequests = 0;
        for (int c : count) {
            maxRequests = Math.max(maxRequests, c);
        }
        
        // Collect all servers that handled maxRequests
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                result.add(i);
            }
        }
        
        return result;
    }
}