package mediator;


class Participant {

    private int value = 0;
    private Mediator mediator;

    public Participant(Mediator mediator) {
        this.mediator = mediator;
        mediator.addParticipant(this);
    }

    public void say(int n) {
        mediator.publish(n);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
