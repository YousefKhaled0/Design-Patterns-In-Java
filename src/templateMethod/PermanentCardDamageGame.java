package templateMethod;

public class PermanentCardDamageGame extends CardGame {

    public PermanentCardDamageGame(Creature[] creatures) {
        super(creatures);
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        other.setHealth(other.getHealth() - attacker.getAttack());
        other.setHealth(Math.max(other.getHealth(), 0));
    }
}
