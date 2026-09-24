class Solution {
    public int rob(int[] nums) {
        // int n= nums.length;
        // int sum1=0;
        // int sum2=0;
        // for(int i=0;i<n;i+=2){
        //     sum1+=nums[i];
        // }
        // for(int i=1;i<n;i+=2){
        //     sum2+=nums[i];
        // }
        // return Math.max(sum1,sum2);
        int p1=0;
        int p2=0;
        for(int y:nums){
            int a=Math.max(y+p2, p1);
            p2=p1;
            p1=a;
        }
        return p1;
    }
}