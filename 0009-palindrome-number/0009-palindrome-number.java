class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int p=x;
        long r=0;
        while(p>0){
            int d=p%10;
            r=r*10+d;
            p=p/10;
        }
        return x==r;
    }
}