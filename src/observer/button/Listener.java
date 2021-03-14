package observer.button;

import java.util.Objects;

public class Listener<T> implements AutoCloseable {

    private Event<T> event;
    private Integer id;

    public Listener(Event<T> event, Integer id) {
        this.event = event;
        this.id = id;
    }

    @Override
    public void close() {
        event.removeHandler(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Listener<?> listener = (Listener<?>) o;
        return id.equals(listener.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
