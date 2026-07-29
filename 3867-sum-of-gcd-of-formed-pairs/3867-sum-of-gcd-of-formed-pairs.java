class Solution {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int[] arr = new int[nums.length];
        long sum =0;
        long p=0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max =Math.max(max,nums[i]);
            arr[i]= gcd(nums[i],max);
        }
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        while(i<j){
            p= gcd(arr[i],arr[j]);
            sum+=p;
            i++;
            j--;
        }
        return sum;
    }
}