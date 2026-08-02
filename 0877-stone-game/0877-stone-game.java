class Solution {
    public boolean stoneGame(int[] piles) {
        // return true;
        int sum=0;
        int sum1=0;
        for(int i=0;i<piles.length;i++){
            if(i%2==0){
                sum+=piles[i];
            }
            else{
                sum1+=piles[i];
            }
        }
        if(sum>sum1){
            return true;
        }
        else return true;
    }
}