package chain;

public class Goblin extends Creature {

    protected int attack;
    protected int defence;

    public Goblin() {
        attack = 1;
        defence = 1;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getDefense() {
        return defence;
    }

    @Override
    public String toString() {
        return "Goblin{" +
                "attack=" + attack +
                ", defence=" + defence +
                '}';
    }
}
