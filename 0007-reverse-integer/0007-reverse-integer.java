class Solution {
    public int reverse(int x) {
        int q=0;
        if (x == Integer.MIN_VALUE) return 0;
        if(x<0){
            q=-1*x;
        }
        else q=x;
        long di =0;
        while(q>0){
            int p=q%10;
            di = di*10 + p;
            q=q/10;
        }
        if(di>Integer.MAX_VALUE){
            return 0;
        } 
        return (int) (x < 0 ? -di : di);
    }
}