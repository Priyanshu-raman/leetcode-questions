class Solution {
    public void sortColors(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int r=0;
        while(r<=j){
            if(nums[r]==0){
                int t=nums[i];
                nums[i]=nums[r];
                nums[r]=t;
                r++;
                i++;
            }else if(nums[r]==2){
                int temp=nums[j];
                nums[j]=nums[r];
                nums[r]=temp;
                j--;
            }
            else{
                r++;
            }
        }
    }
}