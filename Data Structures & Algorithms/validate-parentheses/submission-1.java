class Solution {
    public boolean isValid(String s) {
       Stack<Character> stack = new Stack<>(); 

       for(char ch : s.toCharArray()){
        if(ch == '{' || ch == '[' || ch == '('){
            stack.push(ch);
        } else{
            if(stack.empty()){ return false; }

            char dh = stack.pop();
            if((dh == '{' && ch != '}') || (dh == '[' && ch != ']') || (dh == '(' && ch != ')')) {
                return false;
            }
        }
       }

       if(stack.empty()){ return true;}

       return false;
    }
}
