package isel.poo.fs;

public class Folder extends Entry {
    public Folder(String name) {
        super(name);
    }
    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public String toString() {
        return "...";
    }
    public void add(Entry entry) {

    }
}
