package visitor;

public abstract class Expression {
    abstract void accept(ExpressionVisitor ev);
}
