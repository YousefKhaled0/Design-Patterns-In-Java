package interpreter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ExpressionParser {

    public Expression parse(String input) {
        List<Character> operators = new ArrayList<>();
        List<String> operands = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-') {
                if (!isValidOperand(sb.toString())) return new TokenExpression(0);
                operands.add(sb.toString());
                operators.add(input.charAt(i));
                sb.setLength(0);
            } else
                sb.append(input.charAt(i));
        }
        if (sb.length() > 0) {
            if (!isValidOperand(sb.toString())) return new TokenExpression(0);
            operands.add(sb.toString());
        }
        int numberOfVars = 0;
        for (String operand : operands) {
            if (isVar(operand)) numberOfVars++;
        }

        if (numberOfVars > 1) return new TokenExpression(0);

        Collections.reverse(operands);

        Stack<Expression> expressions =
                operands.stream().map(s -> {
                    if (isVar(s)) return new TokenExpression(0);
                    else return new TokenExpression(Integer.parseInt(s));
                }).collect(Collectors.toCollection(Stack::new));

        for (Character operator : operators) {
            Expression left = expressions.pop();
            Expression right = expressions.pop();
            if (operator.equals('+')) {
                expressions.add(new AdditionExpression(left, right));
            } else {
                expressions.add(new SubtractionExpression(left, right));
            }
        }

        if (numberOfVars > 0) return new SolveExpression(expressions.pop());
        else return expressions.pop();
    }

    private boolean isValidOperand(String op) {
        int notNumbers = 0;
        for (int i = 0; i < op.length(); i++) {
            if (op.charAt(i) < '0' || op.charAt(i) > '9') notNumbers++;
        }
        if (notNumbers > 1) return false;
        if (notNumbers < op.length() && notNumbers > 0) return false;

        return true;
    }

    private boolean isVar(String op) {
        return op.charAt(0) < '0' || op.charAt(0) > '9';
    }

    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        Expression exp = parser.parse("s+12-10");
        System.out.println(exp.eval());
    }

}
