class Solution {
    public int[] twoSum(int[] n, int target) {
        int i=0;
        int j=n.length-1;
        while(i<j){
            int sum=n[i]+n[j];
            if(sum>target){
                j--;
            }else if(sum<target){
                i++;
            }else{
                return new int[]{i+1,j+1};
            }
        }
        return new int[]{0,0};
    }
}