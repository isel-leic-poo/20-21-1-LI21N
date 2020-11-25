package pt.isel.poo.counter;

public class Counter {

    private int value = 0;

    public void inc() { ++value; }
    public void dec() {
        --value;
        if (value<0) value = 0;
    }
    public void reset() {
        value = 0;
    }

    public int getValue() {
        return value;
    }
}
