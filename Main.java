// Java Implementation to convert an Infix Expression to a Postfix Expression
import java.util.Stack;
public class Test {
    // A utility function to precedence of a given operator, Higher the returned value, higher the precedence.
  static int Prec(char ch){
      switch(ch){
          case '+', '-':
              return 1;
          case '*', '/':
              return 2;
          case '^':
              return 3;
      }
      return -1;
  }
  // The main method that converts the infix expression to postfix expression.
    static String infixToPostfix(String exp){
      //Initializing empty string for storing result.
        String result = new String("");
      //Initializing an empty Stack.
      Stack<Character> stack = new Stack<>();
      for(int i=0; i<exp.length(); ++i){
          char c = exp.charAt(i);
          //If the Scanned character is an operand, then add it to output.
          if(Character.isLetterOrDigit(c))
              result+=c;
          //If the Scanned character is '(', push it into the Stack.
          else if(c=='(')
              stack.push(c);
          //If the Scanned character is ')', pop and output from the stack until '(' is encountered.
          else if(c==')'){
              while (!stack.isEmpty()&&stack.peek()!='('){
                  result+=stack.pop();
              }
              stack.pop();
          }
          //When an operator is encountered.
          else{
              while (!stack.isEmpty()&&Prec(c)<=Prec(stack.peek())){
                  result+=stack.pop();
              }
              stack.push(c);
          }
      }
      //Pop all the operators from the stack.
      while (!stack.isEmpty()){
          result+=stack.pop();
      }
      return result;
    }
    //Driver Method
    public static void main(String[] args){
      String exp = "a+b*(c^d-e)^(f+g*h)-i";
      System.out.println(infixToPostfix(exp));
    }
}
