class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closestX = clamp(xCenter, x1, x2);
        int closestY = clamp(yCenter, y1, y2);

        // Calculate distance from circle center to closest point
        int dx = xCenter - closestX;
        int dy = yCenter - closestY;

        // Check if squared distance is within squared radius
        return (dx * dx + dy * dy) <= (radius * radius);
    }

    private int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(val, max));
    }
}