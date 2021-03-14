package interpreter;

public class AdditionExpression implements Expression {

    private Expression left;
    private Expression right;

    public AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int eval() {
        return left.eval() + right.eval();
    }

}
