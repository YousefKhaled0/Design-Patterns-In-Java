package interpreter;

public class SolveExpression implements Expression {

    private Expression expression;

    public SolveExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public int eval() {
        return -expression.eval();
    }
}
