package pt.isel.poo.draw.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Picture  extends LinkedList<Line> {

    public void addLine(Point p) {
        Line l = new Line();
        add( l );
        l.setStart(p);
    }

    public void add(Point p) {
        getLast().add(p);
    }

    public void save(BufferedWriter bw) throws IOException {
        bw.append(Integer.toString(size()));
        bw.newLine();
        for(Line l : this) {
            l.save(bw);
        }
    }
    public void load(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Line l = Line.loadFrom(br);
            add(l);
        }
    }
}

/*
(200,300) (202,301) (204,355) ...
(400,400) (440,430) ...
 */