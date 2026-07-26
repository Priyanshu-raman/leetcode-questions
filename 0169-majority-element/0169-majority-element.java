class Solution {
    public int majorityElement(int[] nums) {
       int p=0;
       int q=nums.length;
       for(int i=0;i<q;i++){
       int c=0;
        for(int j=0;j<q;j++){
            if(nums[i]==nums[j]){
                c++;
            }
        }
        if(c>q/2){
            return nums[i];
        }
       }
       return -1;
    }
}