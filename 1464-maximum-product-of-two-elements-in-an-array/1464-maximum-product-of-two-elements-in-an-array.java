class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int max1=Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++)
        for(int no : nums){
            if(no>max){
                max1=max;
                max=no;
            }
            else if(no>max1){
                max1=no;
            }
        }
        int p=max1-1;
        int q=max-1;
        return p*q;
    }
}