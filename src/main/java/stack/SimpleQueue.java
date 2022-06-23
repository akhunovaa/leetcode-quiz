package stack;

import java.util.ArrayList;

public class SimpleQueue<T> implements Queue<T> {

    private final ArrayList<T> list = new ArrayList<>();

    @Override
    public void add(T item) {
        list.add(item);
    }

    @Override
    public T remove() {
        return list.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

}
