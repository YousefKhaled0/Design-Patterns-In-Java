package visitor;

class ExpressionPrinter extends ExpressionVisitor {
    private StringBuilder sb = new StringBuilder();

    @Override
    public String toString() {
        return sb.toString();
    }

    @Override
    void visit(Value value) {
        sb.append(value.getValue());
    }

    @Override
    void visit(AdditionExpression ae) {
        sb.append("(");
        ae.getLhs().accept(this);
        sb.append("+");
        ae.getRhs().accept(this);
        sb.append(")");
    }

    @Override
    void visit(MultiplicationExpression me) {
        sb.append("(");
        me.getLhs().accept(this);
        sb.append("*");
        me.getRhs().accept(this);
        sb.append(")");
    }
}