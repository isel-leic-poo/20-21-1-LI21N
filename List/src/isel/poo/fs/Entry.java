package isel.poo.fs;

public abstract class Entry {
    private String name;

    public Entry(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public String toString() { return name; }

    public abstract int getSize();
}
