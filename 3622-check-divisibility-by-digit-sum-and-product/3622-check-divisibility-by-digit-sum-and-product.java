class Solution {
    public boolean checkDivisibility(int n) {
        int d=n;
        int de=0;
        int p=0;
        int sum=0;
        int pro=1;
        while(d>0){
            de=d%10;
            p=p*10+de;
            sum=sum+de;
            pro=pro*de;
            d=d/10;
        }
        
       int t=sum+pro;
       return t!=0 && n%t==0;
    }
}