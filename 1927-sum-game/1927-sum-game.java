class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sumDiff = 0;
        int qDiff = 0;

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            int sign = (i < n / 2) ? 1 : -1;

            if (ch == '?') {
                qDiff += sign;
            } else {
                sumDiff += sign * (ch - '0');
            }
        }

        // If the difference in '?' is odd, Alice always wins
        if ((qDiff % 2) != 0) {
            return true;
        }

        // Bob can only balance if the sum difference matches (qDiff / 2) * -9
        return sumDiff * 2 + qDiff * 9 != 0;
    }
}