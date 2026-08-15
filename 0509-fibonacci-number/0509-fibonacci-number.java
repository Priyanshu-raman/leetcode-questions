class Solution {
    public int fib(int n) {
    //    int p=fib(n-1);
    //    int s=fib(n-2);
    //    return p+s;
    int q=0;
    int w=1;
    for(int i=0;i<n;i++){
        int c=q+w;
        q=w;
        w=c;
    }
    return q;
    }
}