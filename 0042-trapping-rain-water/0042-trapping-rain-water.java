class Solution {
    public int trap(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=height[i];
        int sum=0;
        int f=height[j];
        
        while(i<j){
            if(max<f){
                i++;
                max=Math.max(max,height[i]);
                sum+=max-height[i];
               
            }else{
                j--;
                f=Math.max(f,height[j]);
                sum+=f-height[j];
                
            }
        }
        return sum;
    }
}

// class Solution {
//     public int trap(int[] height) {
//         if (height == null || height.length == 0) return 0;

//         int left = 0, right = height.length - 1;
//         int leftMax = height[left], rightMax = height[right];
//         int water = 0;

//         while (left < right) {
//             if (leftMax < rightMax) {
//                 left++;
//                 leftMax = Math.max(leftMax, height[left]);
//                 water += leftMax - height[left];
//             } else {
//                 right--;
//                 rightMax = Math.max(rightMax, height[right]);
//                 water += rightMax - height[right];
//             }
//         }
//         return water;
//     }
// }
























// if(height[i]>max){
            //     int y=height[i]-max;
            //     sum
            //     max=height[i];
            // }
            // else if(height[i]<max){
            //     if(height[i-1]>=height[i]){
            //         sum+=height[i-1]-height[i];
            //     }
            //     else{
            //         sum+=height[i]-height[i-1];
            //     }
            // }  