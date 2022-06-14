

/**
 * Converter class: Takes an infix expression and converts to a postfix expression that can be evaluated.
 * HW 2 Data Structures, Prof. Korth
 *
 * @Abhi Vachani
 * @10/13/2021
 */

public class Converter
{
    // Constructor
    public Converter() {}
   
    // toPostFix Method, converts infix to postfix 
    public static String toPostFix(String infix)
    {
        // new Stack
        Stack<Character> S = new ArrayStack<>();
        char c;
        // postfix output string
        String postfix = "";
       
        
        for (int i = 0; i < infix.length(); i++)
        {
            c = infix.charAt(i);
            
            // checks for operand
            if (Character.isDigit(c))
            {
                postfix = postfix + c;
            }
            
            // Operator check
            else if (isOperator(c)) {
                
                if (S.isEmpty()) {
                    S.push(c);
                    
                }
                
                
                else {
        
                while (!S.isEmpty() && getPrecedence(c) >= getPrecedence(S.top())){
                   postfix = postfix + S.pop();
                }
                S.push(c);
                
 
                }
                
                
            }
            
            // Checks open parenthesis
            else if (c == '('){
                S.push(c);
                
                
            }
            
            // Close Paranthesis check
            else if (c == ')'){
                while (!S.isEmpty() && S.top() != '(') {
                    postfix = postfix + S.pop();
                }
                S.pop();
            }
            

            
        }
        
        // popping last operators from stack and adding to postfix string
        while (!S.isEmpty()){
            postfix = postfix + S.pop();
        }
            
        return postfix;
    }
    
    // isOperator method, checks if character is an operator
    private static boolean isOperator(char c) {
        if (c == '*' || c == '/' || 
	                   c == '+' || c == '^' || 
	                   c == '-') {
	                       return true;
	            
	        }
	        else {
	            return false;
	           }
        
        
        
    }
    
    
    // Get precedence method, gets precedence of operators
    private static int getPrecedence(char c) {
        
        int value = 0;
        if (c == '+' || c =='-') {
            value = 0;
        }
        else if (c == '*' || c == '/') {
            
            value = 1;
            
            
        }
        else if (c == '^') {
            value = 2;
        }
        else if(c == '(') {
            value = 3;
        }
        
        return value;
        
      

        
    }
    
}
