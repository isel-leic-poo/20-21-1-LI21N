package isel.poo.fs;

public class Link extends Entry {
    private final Entry source;

    Link(String name, Entry src) {
        super(name);
        source = src;
    }

    @Override
    public int getSize() { return 0; }

    @Override
    public String toString() {
        return name+"->"+source.pathName();
    }
}
