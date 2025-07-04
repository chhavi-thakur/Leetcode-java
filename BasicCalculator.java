import java.util.Stack;

public class BasicCalculator {

    // Core method to evaluate the expression
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int result = 0;
        int num = 0;
        int sign = 1;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                num = 10 * num + (ch - '0');
            } else if (ch == '+') {
                result += sign * num;
                sign = 1;
                num = 0;
            } else if (ch == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            } else if (ch == '(') {
                stk.push(result);
                stk.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * num;
                result *= stk.pop(); // sign before parenthesis
                result += stk.pop(); // result calculated before parenthesis
                num = 0;
            }
        }

        return result + (sign * num);
    }

    // Main method for testing
    public static void main(String[] args) {
        BasicCalculator calc = new BasicCalculator();

        String expression = "(1+(4+5+2)-3)+(6+8)";
        int result = calc.calculate(expression);
        System.out.println("Result: " + result); // Expected: 23
    }
}
