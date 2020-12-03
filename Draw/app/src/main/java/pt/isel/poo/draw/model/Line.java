package pt.isel.poo.draw.model;

import java.util.Iterator;
import java.util.LinkedList;

public class Line extends LinkedList<Point> /*implements Iterable<Point>*/ {
    private Point start;
    //private final LinkedList<Point> line = new LinkedList<>();

    public Point getStart() {
        return start;
    }
    public void setStart(Point p) {
        start = p;
        clear();
    }
    /*
    public void add(Point p) {
        line.add(p);
    }
    @Override
    public Iterator<Point> iterator() {
        return line.iterator();
    }
     */
}
