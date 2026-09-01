class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int startR = -1, startC = -1;
        List<int[]> litters = new ArrayList<>();

        // Map litter coordinates to bit positions
        int[][] litterIndex = new int[m][n];
        for (int[] row : litterIndex) {
            Arrays.fill(row, -1);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    startR = r;
                    startC = c;
                } else if (ch == 'L') {
                    litterIndex[r][c] = litters.size();
                    litters.add(new int[]{r, c});
                }
            }
        }

        int k = litters.size();
        int targetMask = (1 << k) - 1;

        // Base case: if there's no litter to collect
        if (targetMask == 0) {
            return 0;
        }

        // visited[r][c][mask] stores the maximum remaining energy seen so far
        int[][][] maxEnergy = new int[m][n][1 << k];
        for (int[][] row : maxEnergy) {
            for (int[] cell : row) {
                Arrays.fill(cell, -1);
            }
        }

        // Queue stores: [r, c, mask, energy, steps]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC, 0, energy, 0});
        maxEnergy[startR][startC][0] = energy;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int mask = curr[2];
            int curEnergy = curr[3];
            int steps = curr[4];

            if (mask == targetMask) {
                return steps;
            }

            // Cannot move forward if no energy left
            if (curEnergy == 0) {
                continue;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                // Check bounds and obstacle
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                int nextEnergy = curEnergy - 1;
                int nextMask = mask;
                char nextCell = classroom[nr].charAt(nc);

                // Hit a reset area
                if (nextCell == 'R') {
                    nextEnergy = energy;
                }

                // Hit an uncollected litter
                if (nextCell == 'L' && litterIndex[nr][nc] != -1) {
                    nextMask |= (1 << litterIndex[nr][nc]);
                }

                // If this state has already been reached with >= energy, prune it
                if (nextEnergy > maxEnergy[nr][nc][nextMask]) {
                    maxEnergy[nr][nc][nextMask] = nextEnergy;
                    queue.offer(new int[]{nr, nc, nextMask, nextEnergy, steps + 1});
                }
            }
        }

        return -1; // Unreachable
    }
}