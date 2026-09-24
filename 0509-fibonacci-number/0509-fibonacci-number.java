class Solution {
    public int fib(int n) {
        // if(n==1) return 1;
        // if(n==0) return 0;
        // return fib(n-1)+fib(n-2);
        if(n==0) return 0;
        int q=0;
        int w=1;
        for(int i=2;i<=n;i++){
            int c= q+w;
            q=w;
            w=c;
        }
        return w;
    }
}