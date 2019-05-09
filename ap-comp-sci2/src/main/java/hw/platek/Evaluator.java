package hw.platek;

import java.util.Stack;

public class Evaluator{

    private static String getOperators() {
        return "+-*/%sqrt";
    }

    private static String getNumbers() {
        return "0123456789";
    }
    // precondition: exp is a String expression that is fully parenthesized (a set
    //               of parentheses for each operator).
    // postcodition: returns a String [] of the tokens of exp.
    //               ex. getTokens("(5-2.2)") -> ["(","5","-","2.2",")"]
    public static String[] getTokens(String exp){
        exp = exp.replaceAll(" ", "");
        String[] tokens = exp.split("(?<=[^\\.a-zA-Z\\d])|(?=[^\\.a-zA-Z\\d])");
        return tokens;
    }


    // precondition: receives an array of the tokens of an infix expression.
    //               tokens must be one of the following:
    //               (),+-*/%,sqrt
    // postcondition: evalutes the expression represented in expTokens
    //             ex. evaluate(["(","5","-","2.2",")"]) returns 2.8
    public static Double evaluate(String[] expTokens) {
        Stack<String> operators = new Stack();
        Stack<Double> operands = new Stack();
        Stack<Integer> parenIndex = new Stack();
        double val = 0;
        for(int i = 0; i < expTokens.length; i++) {
            if(expTokens[i].equals(")"))
                parenIndex.push(operands.size());
            if(expTokens[i].equals("(")) {
                for(int j = i; j < parenIndex.pop(); i++) {

                }
            }
        }
        return new Double(val);
    }

    public static boolean sieve(String s) {
        return getOperators().contains(s);
    }

    public static void main(String [] args){
        String[] expressions = {"(2+3)","(4 + (3 - 2))", "((5 *(10 + (32 - 8))/ 2.0))", "( sqrt  (16 * 16) )", "(( 25 % 3 ) + 9)"};
        Double[] expectedResults = {5.0,5.0,85.0,16.0,10.0};

        for (int i = 0; i < expressions.length; i++){
            String[] tokens = getTokens(expressions[i]);
            Double  ansObserved = evaluate(tokens);
            Double  ansExpected = expectedResults[i];
            System.out.println(expressions[i] + " = " + evaluate(tokens));
            System.out.println("observed: " + ansObserved + " expected: " + ansExpected);
            System.out.println("correct? " + (ansObserved.equals( ansExpected)));
        }
    }
    
}


