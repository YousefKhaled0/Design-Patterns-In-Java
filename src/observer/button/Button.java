package observer.button;

import java.util.function.Consumer;

public class Button {

    private Event<ButtonClickEvent> observer =
            new Event<>();
    private final ButtonClickEvent buttonClickEvent = new ButtonClickEvent();

    public void click() {
        System.out.println("Button Clicked!");
        observer.fire(buttonClickEvent);
    }

    public Listener addListener(Consumer<ButtonClickEvent> handler) {
        return observer.addHandler(handler);
    }

    public void removeListener(Listener listener) {
        observer.removeHandler(listener);
    }

    public static void main(String[] args) {
        Button button = new Button();
        button.click();
        Listener listener = button.addListener(buttonClickEvent -> {
            System.out.println("Button clicked ---- event!");
        });
        button.click();
        button.removeListener(listener);
        button.click();
        Listener listener2 = button.addListener(buttonClickEvent -> {
            System.out.println("Button clicked ---- event! 2");
        });
        button.click();
        button.click();
        button.click();
        button.click();
        button.click();
    }
}
