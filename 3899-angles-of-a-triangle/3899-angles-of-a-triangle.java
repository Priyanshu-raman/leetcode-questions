class Solution {
    public double[] internalAngles(int[] sides) {
        Arrays.sort(sides);
        int a = sides[0], b = sides[1], c = sides[2];
        
        // Check if a valid triangle with positive area can be formed
        if (a + b <= c) {
            return new double[0];
        }
        
        // Apply Law of Cosines to find angles A and B
        double A = Math.toDegrees(Math.acos((double)(b * b + c * c - a * a) / (2.0 * b * c)));
        double B = Math.toDegrees(Math.acos((double)(a * a + c * c - b * b) / (2.0 * a * c)));
        double C = 180.0 - A - B;
        
        return new double[] { A, B, C };
    }
}