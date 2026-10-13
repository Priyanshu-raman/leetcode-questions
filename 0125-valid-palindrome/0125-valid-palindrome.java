class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        String q=s.toLowerCase();
        while(i<j){
            char c=q.charAt(i);
            char e=q.charAt(j);
            if (!Character.isLetterOrDigit(c)) {
                i++;
            }
            else if(!Character.isLetterOrDigit(e)){
                j--;
            }
            else{
                if(c==e){
                    i++;
                    j--;
                }else{
                    return false;
                }
            }   
        }
        return true;
    }
}