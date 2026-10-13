class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        int sum=0;
        while(i<=j){
            sum=i + (j - i) / 2;
            if(nums[sum]==target){
                return sum;
            }else if(nums[sum]>target){
                j=sum-1;
            }else{
                i=sum+1;
            }
        }
        return i;
    }
}