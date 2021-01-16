package pt.isel.poo.escape.model;

public class Actor {
    Point local;
    protected Actor(Point local) {
        this.local = local;
    }
    void moveInDirectionOf(Point target) {
        local = local.add( local.dirTo(target) );
    }

    public Point getLocal() { return local; }
}
