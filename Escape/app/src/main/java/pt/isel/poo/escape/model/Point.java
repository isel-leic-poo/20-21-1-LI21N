package pt.isel.poo.escape.model;

public class Point {
    public final int line;
    public final int col;

    public Point(int line, int col) {
        this.line = line;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return line==point.line && col==point.col;
    }

    @Override
    public int hashCode() {
        return col + 31 * line;
    }
}
