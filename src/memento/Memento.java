package memento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Memento {
    private List<Token> tokens = new ArrayList<>();

    public Memento(List<Token> tokens) {
        this.setTokens(tokens);
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens.stream().map(token -> new Token(token.getValue()))
                .collect(Collectors.toList());
    }

    public List<Token> getTokens() {
        return tokens;
    }

    @Override
    public String toString() {
        return "Memento{" +
                "tokens=" + tokens +
                '}';
    }
}