package isel.poo.fs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Folder extends Entry {
    private final List<Entry> entries = new LinkedList<>();
    public Folder(String name) {
        super(name);
    }
    @Override
    public int getSize() {
        int totalSize = 0;
        for(Entry e : entries)
            totalSize += e.getSize();
        return totalSize;
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder(name);
        str.append('{');
        Iterator<Entry> it = entries.iterator();
        if (it.hasNext()) str.append(it.next().toString());
        while (it.hasNext())
            str.append(',').append(it.next().toString());
        return str.append('}').toString();
    }

    public void add(Entry entry) {
        entries.add(entry);
        entry.parent = this;
    }
}
