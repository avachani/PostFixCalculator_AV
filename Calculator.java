
/**
 * PostFix Calculator, Calculates postfix expression
 * HW 2 Data Structures, Prof. Korth
 *
 * @Abhi Vachani
 * @10/13/2021
 */
public class Calculator 
{
    // Main
    public static void main(String[] args) {
        // Instantiating Converter object
        Converter post = new Converter();
        // Infix
        String inFix = "(4+8)*(6-5)/((3-2)*(2+2))";
        // Postfix
        String postFix = post.toPostFix(inFix);
  
        // Calculating
        double result = Calculate(postFix);
        
        // Printing results
        System.out.println("Infix: " + inFix);
        System.out.println("Postfix: " + postFix);
        System.out.println("Result "+ result);
        
        
    }
    
    // Calculate Method, Calculates postfix expression using stack
    public static double Calculate(String postfix) {
        
        // new stack
        Stack<Integer> S = new ArrayStack<>();
        
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            
            if (Character.isDigit(c))
            S.push(Character.getNumericValue(c));
            // Different Operator Cases
            else{
                int left = S.pop();
                int right = S.pop();
                if (c == '+')
                S.push(right + left);
                
                else if (c == '-')
                S.push(right - left);
                
                else if (c == '*')
                S.push(right * left);
                
                else if (c == '/')
                S.push(right / left);
                
                else if (c == '^')
                S.push((int) Math.pow(right, left));
                

                
            }
            
 
            
        }
        
        
        // Return result
        return S.pop();
    }
    
}
