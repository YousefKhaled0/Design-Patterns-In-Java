package state.classic;

public class LightSwitch {
    private State currentState;

    public LightSwitch() {
        currentState = new OffState();
    }

    public void on() {
        currentState.on(this);
    }

    public void off() {
        currentState.off(this);
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public static void main(String[] args) {
        LightSwitch lightSwitch = new LightSwitch();
        lightSwitch.on();
        lightSwitch.on();
        lightSwitch.off();
        lightSwitch.off();
    }
}
