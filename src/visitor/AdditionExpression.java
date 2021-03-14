package visitor;

public class AdditionExpression extends Expression {

    private Expression lhs, rhs;

    public AdditionExpression(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    void accept(ExpressionVisitor ev) {
        ev.visit(this);
    }

    public Expression getLhs() {
        return lhs;
    }

    public void setLhs(Expression lhs) {
        this.lhs = lhs;
    }

    public Expression getRhs() {
        return rhs;
    }

    public void setRhs(Expression rhs) {
        this.rhs = rhs;
    }
}
