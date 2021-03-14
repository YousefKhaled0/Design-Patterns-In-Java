package templateMethod;

public abstract class CardGame {
    private Creature[] creatures;

    public CardGame(Creature[] creatures) {
        this.creatures = creatures;
    }

    public int combat(int creature1, int creature2) {
        Creature first = creatures[creature1];
        Creature second = creatures[creature2];
        hit(first, second);
        if (second.getHealth() == 0) return 1;
        hit(second, first);
        if (first.getHealth() == 0) return 2;
        return 0;
    }

    protected abstract void hit(Creature attacker, Creature other);
}
