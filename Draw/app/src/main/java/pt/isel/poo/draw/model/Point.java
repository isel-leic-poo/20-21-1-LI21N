package pt.isel.poo.draw.model;

import java.util.Scanner;

public class Point {
    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "(" + x + ',' + y + ')';
    }
    public static Point fromString(String txt) {
        /*
        Scanner s = new Scanner(txt);
        s.useDelimiter(",\\(\\)");
        int x = s.nextInt();
        int y = s.nextInt();
        */
        final int idx = txt.indexOf(',');
        final int x = Integer.parseInt(txt.substring(1,idx));
        final int y = Integer.parseInt(txt.substring(idx+1,txt.length()-1));
        return new Point(x,y);
    }
}
