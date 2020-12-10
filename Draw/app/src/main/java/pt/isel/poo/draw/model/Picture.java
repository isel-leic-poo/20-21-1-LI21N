package pt.isel.poo.draw.model;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public class Picture  extends LinkedList<Line> { //implements Iterable<Line>{
    //private final LinkedList<Line> lines = new LinkedList<>();

    /*@Override
    public Iterator<Line> iterator() {
        return lines.iterator();
    }
    */

    public void addLine(Point p) {
        Line l = new Line();
        add( l );
        l.setStart(p);
    }

    public void add(Point p) {
        getLast().add(p);
    }
    public void save(OutputStream os) {

    }
}
