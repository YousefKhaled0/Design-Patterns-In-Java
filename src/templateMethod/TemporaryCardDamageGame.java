package templateMethod;

public class TemporaryCardDamageGame extends CardGame {

    public TemporaryCardDamageGame(Creature[] creatures) {
        super(creatures);
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        if (other.getHealth() - attacker.getAttack() <= 0)
            other.setHealth(0);
    }
}
