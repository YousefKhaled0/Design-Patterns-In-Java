package interpreter;

public class SubtractionExpression implements Expression {

    private Expression left;
    private Expression right;

    public SubtractionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int eval() {
        return left.eval() - right.eval();
    }

}
