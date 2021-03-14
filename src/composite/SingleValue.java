package composite;

import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SingleValue implements ValueContainer {

    private Integer value;

    public SingleValue(Integer value) {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(value).iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Collections.singleton(value).forEach(action);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Collections.singleton(value).spliterator();
    }
}
