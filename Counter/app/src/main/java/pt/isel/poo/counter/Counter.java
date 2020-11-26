package pt.isel.poo.counter;

public class Counter {

    private int value = 0;

    public void inc() { setValue(value+1); }
    public void dec() { setValue(value-1); }
    public void reset() {
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int val) {
        value = val;
        if (value<0) value=0;
    }
}
