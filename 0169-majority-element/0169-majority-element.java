class Solution {
    public int majorityElement(int[] nums) {
    //    int c=0;
    //    int can=0;
    //    for(int num : nums){
    //     if(c==0){
    //         can=num;
    //     }
    //     if(num==can){
    //         c++;
    //     }
    //     else{
    //         c--;
    //     }
    //    }
    //    return can;




    // Arrays.sort(nums);
    // int p=nums.length/2;
    // return nums[p];
    


    int c=0;
    int can=0;
    for(int no:nums){
        if(c==0){
            can=no;
        }
        if(no==can){
            c++;
        }
        else{
            c--;
        }
    }
    return can;
    }
}