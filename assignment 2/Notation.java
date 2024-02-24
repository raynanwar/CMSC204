/*
 
Class: CMSC204
Instructor: Eivzi
Description: Infix to postifx 
Due: 2/25
Platform/compiler: Eclipse
I pledge that I have completed the programming
assignment independently. I have not copied the code
from a student or any source. I have not given my code
to any student.
Print your Name here:= Rayn Anwar
*/
public class Notation {
   
        public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
            MyStack<String> stack = new MyStack<>(); 
    
            for(int i =0; i<postfixExpr.length(); i++) {
                Character c = postfixExpr.charAt(i);
                try {
                    checkCharacterEvaluation(c, stack);
                }
                catch(InvalidNotationFormatException e) {
                    throw new InvalidNotationFormatException();
                }
                
                
            }
            double result =Double.parseDouble(stack.pop());
            if(stack.size()==0) {
                return result;
            } else {
                throw new InvalidNotationFormatException();
            }
           
        }
        public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
            StringBuilder postFix = new StringBuilder();
            MyStack<String> stack = new MyStack<>(); 
            MyQueue<String> queue = new MyQueue<>();
            for(int i =0; i<infix.length(); i++) {
                Character c = infix.charAt(i);
                checkCharacter(c, stack, queue);
            }
            while(!stack.isEmpty()) {
                queue.enqueue(stack.pop());
            }
            while(!queue.isEmpty()){
                postFix.append(queue.dequeue());
            }
            return postFix.toString(); 
        }
        private static void checkCharacter(Character c, MyStack<String> stack, MyQueue<String> queue) {
            if(Character.isDigit(c)) {
                queue.enqueue(String.valueOf(c));
            } else {
                switch (c) {
                    case '(':
                        stack.push("(");
                        break;
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        isOperator(stack, c, queue);
                        break;
                    case ' ':
                       return;
                   case ')': {
                   while(!stack.isEmpty() && !stack.top().equals("(")) {
                    queue.enqueue(stack.pop());
                   }
                   if(stack.isEmpty()) {
                    throw new InvalidNotationFormatException();
                   }
                   stack.pop();
                   
                }
                }
            }
        }
        private static void isOperator(MyStack<String> stack, char c, MyQueue<String> queue) {
            int precedenceChar = getPrecedence(c);
            
            while (!stack.isEmpty()) {
                char topOperator = stack.top().charAt(0);
                int precedenceTop = getPrecedence(topOperator);
                
                if (precedenceTop >= precedenceChar) {
                    queue.enqueue(stack.pop());
                } else {
                    break;
                }
            }
            
            stack.push(String.valueOf(c));
        }
    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
        }

    private static void checkCharacterEvaluation(Character c, MyStack<String> stack) {
        if(Character.isDigit(c)) {
            stack.push(String.valueOf(c));
        } else {
            switch(c) {
                case '(': 
                    stack.push("(");
                    break;
                case '+': 
                case '-':
                case '*':
                case '/':
                isOperatorInfixToPostfix(stack, c);
                break;   
                case ' ': 
                return;        
        }
     
      }
    }
    private static void isOperatorInfixToPostfix(MyStack<String> stack, char operator) {
        if(stack.size()<2) {
            throw new InvalidNotationFormatException();
        }
        double rightOperand = Double.parseDouble(stack.pop());
        double leftOperand = Double.parseDouble(stack.pop());
        double result;
        switch(operator) {
            case '+': 
                result = leftOperand+rightOperand;
                stack.push(Double.toString(result));
            break;

            case '-':
            result = leftOperand - rightOperand;
            stack.push(Double.toString(result));
            break;

            case '*':
            result = leftOperand * rightOperand;
            stack.push(Double.toString(result));
            break;

            case '/':
            result  = leftOperand/rightOperand;
            stack.push(Double.toString(result));
            break;
        }

    }
    public static String convertPostfixToInfix (String postfix) throws InvalidNotationFormatException {
        StringBuilder infixString = new StringBuilder();
       MyStack<String> stack =  new MyStack<>();
        for(int i =0; i<postfix.length(); i++) {
        Character c  = postfix.charAt(i);
            checkCharacterPostfixToInfix(c, stack);
        }
        if(stack.size()>1) {
            throw new InvalidNotationFormatException();
        }
        infixString.append(stack.pop());
        return infixString.toString();
    }
    private static void checkCharacterPostfixToInfix(Character c, MyStack<String> stack) {
        if(Character.isDigit(c)) {
            stack.push(String.valueOf(c));
        } else {
            switch(c) {
                case '+': 
                case '-':
                case '*':
                case '/':
                    isOperatorPostfixToInfix(stack, c);
                break;   
                case ' ': 
                return;        
        }
     
      }
    }
    private static void isOperatorPostfixToInfix(MyStack<String> stack, Character c) throws InvalidNotationFormatException {
        StringBuilder infixString = new StringBuilder("(");
        if(stack.size()<2) {
            throw new InvalidNotationFormatException();
        }
        String rightOperand;
        String leftOperand;
       rightOperand = (stack.pop());
        
        leftOperand = (stack.pop());
        infixString.append(leftOperand);
        infixString.append(c);
        infixString.append(rightOperand);

        infixString.append(")");
     
     
     stack.push(infixString.toString());

    }
}
