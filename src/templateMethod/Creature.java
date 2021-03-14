package templateMethod;

class Creature {
    private int attack, health;

    public Creature(int attack, int health) {
        this.attack = attack;
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}