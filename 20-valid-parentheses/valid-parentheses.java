class Solution {
    public boolean isValid(String str) {
           Stack <Character> st=new Stack<>();
           for(int i=0;i<str.length();i++) {
             if ((str.charAt(i)=='(') || (str.charAt(i)=='{') || (str.charAt(i)=='[')){
                st.push(str.charAt(i));
             }
             else{
                if(st.isEmpty()) return false;
                else{
                    char ch=st.peek();
                    st.pop();
                    if ((ch=='(' && str.charAt(i)!=')') || (ch=='{' && str.charAt(i)!='}') || (ch=='[' && str.charAt(i)!=']')) {
                        return false;
                    }
                }
             }

           }
           return st.isEmpty();
    }
}