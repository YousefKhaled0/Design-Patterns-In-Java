package memento;

import java.util.ArrayList;
import java.util.List;

class TokenMachine {
    public List<Token> tokens = new ArrayList<>();

    public Memento addToken(int value) {
        tokens.add(new Token(value));
        return new Memento(tokens);
    }

    public Memento addToken(Token token) {
        tokens.add(token);
        return new Memento(tokens);
    }

    public void revert(Memento m) {
        this.tokens.clear();
        this.tokens.addAll(m.getTokens());
    }

    @Override
    public String toString() {
        return "TokenMachine{" +
                "tokens=" + tokens +
                '}';
    }

    public static void main(String[] args) {
        TokenMachine tokenMachine = new TokenMachine();
        Token token = new Token(10);
        Memento memento = tokenMachine.addToken(token);
        tokenMachine.addToken(300);
        System.out.println(tokenMachine);
        tokenMachine.revert(memento);
        System.out.println(tokenMachine);
    }
}