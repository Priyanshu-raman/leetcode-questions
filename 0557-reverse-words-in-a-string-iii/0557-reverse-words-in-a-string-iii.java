class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int q=s.length();
        int r=0;
        int a=0;
        for(int i=0;i<q;i++){
            if(arr[i]==' ' || i==q-1){
                a=(arr[i]==' ')?i-1:i;
                int left =r;
                int right = a;
            
                while(left<right){
                    char temp = arr[left];
                    arr[left]=arr[right];
                    arr[right]=temp;
                    left++;
                    right--;
                }
                r=i+1;
            
            }
            
        }
        return new String(arr);
    }
}