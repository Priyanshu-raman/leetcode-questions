class Solution {
    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                StringBuilder s1 = new StringBuilder(s);
                s1.deleteCharAt(i);

                StringBuilder s2 = new StringBuilder(s);
                s2.deleteCharAt(j);
                return isPalindrom(s1.toString()) || isPalindrom(s2.toString());
            }
            i++;
            j--;
        }
        return true;
    }
    private boolean isPalindrom(String s){
        StringBuilder sb =new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }
    //     int i=0;
    //     int j=s.length()-1;
    //     while(i<j){
    //         if(s.charAt(i)!=s.charAt(j)){
    //             return isPalindromeRange(s, i + 1, j) || isPalindromeRange(s, i, j - 1);
    //         }
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
    // private boolean isPalindromeRange(String s, int i,int j){
    //     while(i<j){
    //         if(s.charAt(i)!=s.charAt(j)){
    //             return false;
    //         }
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
}