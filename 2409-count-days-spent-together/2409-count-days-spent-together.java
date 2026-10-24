class Solution {
    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
       int startAlice = dayOfYear(arriveAlice);
        int leaveAliceDay = dayOfYear(leaveAlice);
        int startBob = dayOfYear(arriveBob);
        int leaveBobDay = dayOfYear(leaveBob);

        int overlapStart = Math.max(startAlice, startBob);
        int overlapEnd = Math.min(leaveAliceDay, leaveBobDay);

        return Math.max(0, overlapEnd - overlapStart + 1);
    }

    private int dayOfYear(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int days = 0;
        for (int i = 0; i < month - 1; i++) {
            days += DAYS_IN_MONTH[i];
        }

        return days + day; 
    }
}