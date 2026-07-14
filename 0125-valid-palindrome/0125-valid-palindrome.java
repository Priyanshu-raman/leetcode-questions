class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            else{
                char low=Character.toLowerCase(s.charAt(i));
                char rig=Character.toLowerCase(s.charAt(j));
                if(low != rig){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}