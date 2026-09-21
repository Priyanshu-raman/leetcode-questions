class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n=heights.length;
        int[] arr= new int[n];
        Stack<Integer> st= new Stack<>();
        st.push(heights[n-1]);
        arr[n-1]=0;
        for(int i=n-2;i>=0;i--){
            int c=0;
            while(st.size()>0 && heights[i]>=st.peek()){
                c++;
                st.pop();
            }
            if(st.size()>0) c++;
            arr[i]=c;
            st.push(heights[i]);
        }
        return arr;
    }
}