class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        String ans = "";
        int num  = 0;

        for(int i = 0; i< s.length(); i++){
            char cha = s.charAt(i);
            String ch = String.valueOf(cha);
            
            if(!ch.equals("]")){
                if((int)cha >= 47 && (int)cha <= 56 ){
                    num = num * 10 + (Integer.parseInt(ch));
                } else{
                    if(num != 0){
                        st.push(String.valueOf(num));
                        num = 0;
                    }
                    st.push(ch);
                }
            } else{
                String temp = "";
                // System.out.println("Removing ele from stack");
                while(!st.peek().equals("[")){
                    // System.out.println(st.peek());
                    temp = st.pop() + temp;
                }

                st.pop();
                int rep = Integer.parseInt(st.pop());
                // System.out.println(temp + "  " + rep);

                temp = temp.repeat(rep);
                st.push(temp);
            }
        }

        while(!st.isEmpty()){
            String temp = st.pop();
            ans = temp + ans;
        }

        return ans;
    }
}