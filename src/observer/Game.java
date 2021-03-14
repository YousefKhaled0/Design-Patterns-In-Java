package observer;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Game {
    private List<Rat> rats = new ArrayList<>();

    public void addRat(Rat rat) {
        rats.add(rat);
    }

    public void removeRat(Rat rat) {
        rats.remove(rat);
    }

    public int totalAttack() {
        return rats.stream().mapToInt(rat -> 1)
                .sum();
    }

}

class Rat implements Closeable {
    private Game game;
    public int attack = 1;

    public Rat(Game game) {
        this.game = game;
        this.game.addRat(this);
    }

    @Override
    public void close() {
        this.game.removeRat(this);
    }

    public static void main(String[] args) {
        Game game = new Game();
        Rat rat = new Rat(game);
        Rat rat1 = new Rat(game);
        Rat rat2 = new Rat(game);
        Rat rat3 = new Rat(game);
        System.out.println(
                game.totalAttack()
        );
        rat3.close();
        System.out.println(game.totalAttack());
    }
}