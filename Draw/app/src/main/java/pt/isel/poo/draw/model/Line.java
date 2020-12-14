package pt.isel.poo.draw.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Line extends LinkedList<Point> {
    private Point start;

    public Point getStart() {
        return start;
    }

    public void setStart(Point p) {
        start = p;
        clear();
    }

    public void save(BufferedWriter bw) throws IOException {
        bw.append(Integer.toString(size()+1)).append(' ');
        bw.append(start.toString()).append(' ');
        for(Point p : this)
            bw.append(p.toString()).append(' ');
        bw.newLine();
    }

    public static Line loadFrom(BufferedReader br) throws IOException {
        String line = br.readLine();
        int idxSpace = line.indexOf(' ');
        int n = Integer.parseInt( line.substring(0,idxSpace) );
        Line l = new Line();
        for (int i = 0; i < n; i++) {
            int start = idxSpace+1;
            idxSpace = line.indexOf(' ',start);
            Point p = Point.fromString(line.substring(start,idxSpace));
            l.add(p);
        }
        return l;
    }

}
