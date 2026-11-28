class Solution {
    public int evalRPN(String[] to) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<to.length;i++){
            String s=to[i];
            if(s.equals("+")){
                int y=st.pop();
                int u=st.peek();
                int m=y+u;
                st.pop();
                st.push(m);
            }else if(s.equals("-")){
                int z=st.pop();
                int x=st.peek();
                int c=x-z;
                st.pop();
                st.push(c);
            }else if(s.equals("*")){
                int j=st.pop();
                int k=st.peek();
                int l=j*k;
                st.pop();
                st.push(l);
            }else if(s.equals("/")){
                int f=st.pop();
                int g=st.peek();
                int h=g/f;
                st.pop();
                st.push(h);
            }else{
                Integer val = Integer.valueOf(s);
                st.push(val);
            }
        }
        return st.peek();
    }
}