class Solution {
    public int calPoints(String[] op) {
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<op.length;i++){
            String s=op[i];
            if(s.equals("D")) st.push(st.peek()*2);
            else if(s.equals("C")) st.pop();
            else if(s.equals("+")){
                int t=st.pop();
                int y=st.peek();
                int sum=t+y;
                st.push(t);
                st.push(sum);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        int sum=0;
        while(st.size()>0){
            int asf=st.pop();
            sum+=asf;
        }
        return sum;
    }
}
