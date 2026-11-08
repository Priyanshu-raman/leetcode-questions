class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }else if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }else{
                char c=Character.toLowerCase(s.charAt(i));
                char y=Character.toLowerCase(s.charAt(j));
                if(c!=y){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}