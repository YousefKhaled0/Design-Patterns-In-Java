package observer.button;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Event<T> {
    private int count = 0;
    private Map<Listener, Consumer<T>> handlers =
            new HashMap<>();

    public Listener addHandler(Consumer<T> handler) {
        Listener listener = new Listener(this, count++);
        handlers.put(listener, handler);
        return listener;
    }

    public void removeHandler(Listener listener) {
        handlers.remove(listener);
    }

    public void fire(T observable) {
        handlers.values().forEach(handlers -> {
            handlers.accept(observable);
        });
    }
}
