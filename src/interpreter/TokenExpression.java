package interpreter;

public class TokenExpression implements Expression {

    private Integer data;

    public TokenExpression(Integer data) {
        this.data = data;
    }

    @Override
    public int eval() {
        return data;
    }

    @Override
    public String toString() {
        return "TokenExpression{" +
                "data=" + data +
                '}';
    }
}
