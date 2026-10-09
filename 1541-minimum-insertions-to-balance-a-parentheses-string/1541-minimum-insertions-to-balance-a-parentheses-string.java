class Solution {
    public int minInsertions(String s) {
        int openNeeded = 0;
        int insertions = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                openNeeded++;
            } else {
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    if (openNeeded > 0) {
                        openNeeded--;
                    } else {
                        insertions++; // Need an '('
                    }
                    i++; // Skip second ')'
                } else {
                    insertions++; // Need an extra ')' to make "))"
                    if (openNeeded > 0) {
                        openNeeded--;
                    } else {
                        insertions++; // Need an '('
                    }
                }
            }
        }

        return insertions + (openNeeded * 2);
    }
}