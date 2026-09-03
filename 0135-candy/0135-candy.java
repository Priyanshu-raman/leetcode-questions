class Solution {
    public int candy(int[] rat) {
        int n=rat.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (rat[i] > rat[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (rat[i] > rat[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int total = 0;
        for (int c : candies) {
            total += c;
        }

        return total;
















        // int c=0;
        // if(rat[0]>rat[1]){
        //     c+=2;
        // }else{
        //     c++;
        // }
        // int i=1;
        // while(i<rat.length-1){
        //     if(rat[i]>rat[i-1] && rat[i]>rat[i+1]){
        //         c++;
        //     }
        //     if(rat[i]>rat[i-1] || rat[i]>rat[i+1]){
        //         c+=2;
        //     }
        //     else{
        //         c++;
        //     }

        //     i++;
        // }
        // if(rat[rat.length-1]>rat[rat.length-2]){
        //     c+=2;
        // }else{
        //     c++;
        // }
        // return c;



    }
}