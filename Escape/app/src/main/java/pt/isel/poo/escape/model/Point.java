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

    public Point add(Dir dir) { return new Point(line+dir.dLin, col+dir.dCol); }

    public Dir dirTo(Point p) {
        int dLine = reduce(p.line - line);
        int dCol = reduce(p.col - col);
        for( Dir d : Dir.values() )
            if (d.dLin == dLine && d.dCol == dCol) return d;
        return null;
    }
    private static int reduce(int dif) { return dif<=-1 ? -1 : dif>=1 ? 1 : 0; }
}
