package pt.isel.poo.draw.model;

import android.text.InputType;

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
        int idx = txt.indexOf(',');
        int x = Integer.parseInt(txt.substring(1,idx));
        int y = Integer.parseInt(txt.substring(idx+1,txt.length()-1));
        return new Point(x,y);
    }
}
