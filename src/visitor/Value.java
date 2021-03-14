package visitor;

class Value extends Expression {
    private int value;

    public Value(int value) {
        this.value = value;
    }

    @Override
    void accept(ExpressionVisitor ev) {
        ev.visit(this);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}