class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(String ch : tokens){
            if((ch.equals("+")) || (ch.equals("-")) || (ch.equals("*")) || (ch.equals("/"))){
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                
                if(ch.equals("+")){ stack.push( String.valueOf(a + b));}
                else if (ch.equals("-")){ stack.push( String.valueOf(a - b));}
                else if (ch.equals("*")){ stack.push( String.valueOf(a * b));}
                else{ stack.push( String.valueOf(a / b));}
            } else{
                stack.push(ch);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
