package memento;

class Token {
    private int value = 0;

    public Token(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "value=" + value +
                '}';
    }
}
