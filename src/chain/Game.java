package chain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Observer observer = new Observer();

    private List<Creature> creatures = new ArrayList<>();

    public Game() {
        observer.setAttackHandler(queryEvent -> {
            int result = 0;
            for (Creature creature : creatures) {
                if (creature instanceof GoblinKing)
                    result++;
            }
            queryEvent.setResult(result);
        });
        observer.setDefenceHandler(queryEvent -> {
            queryEvent.setResult(creatures.size() - 1);
        });
    }

    public void addCreature(Creature c) {
        creatures.add(c);
        attack();
        defence();
    }

    private void attack() {
        QueryEvent queryEvent = new QueryEvent(Statistic.ATTACK);
        observer.fire(queryEvent);
        Integer result = queryEvent.getResult();
        for (Creature creature : creatures) {
            if (creature instanceof GoblinKing) {
                ((GoblinKing) creature).setAttack(3 + result);
            } else if (creature instanceof Goblin) {
                ((Goblin) creature).setAttack(1 + result);
            }
        }
    }

    private void defence() {
        QueryEvent queryEvent = new QueryEvent(Statistic.DEFENSE);
        observer.fire(queryEvent);
        Integer result = queryEvent.getResult();
        for (Creature creature : creatures) {
            if (creature instanceof GoblinKing) {
                ((GoblinKing) creature).setDefence(1 + result);
            } else if (creature instanceof Goblin) {
                ((Goblin) creature).setDefence(1 + result);
            }
        }
    }

    @Override
    public String toString() {
        return "Game{" + "creatures=" + creatures + '}';
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.addCreature(new Goblin());
        game.addCreature(new GoblinKing());
        game.addCreature(new Goblin());
        System.out.println(game);
    }

}
