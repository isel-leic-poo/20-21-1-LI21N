package isel.poo;

public class Pair<T> {
    public final String key;
    public T value;

    public Pair(String key) {
        super();
        this.key = key;
    }
    public Pair(String key, T val) {
        this(key);
        value = val;
    }
    @Override
    public String toString() {
        return key + " = " + value;
    }
}
