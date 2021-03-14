package state.classic;

public class State {
    public void on(LightSwitch ls) {
        System.out.println("Light already on");
    }

    public void off(LightSwitch ls) {
        System.out.println("Light already off");
    }
}
