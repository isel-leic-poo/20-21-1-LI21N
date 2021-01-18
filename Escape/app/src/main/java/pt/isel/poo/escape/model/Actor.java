package pt.isel.poo.escape.model;

public class Actor {
    Point local;
    Escape model;
    protected Actor(Escape m, Point local) {
        this.local = local;
        model = m;
        model.actors.add(this);
        if (model.listener!=null)
            model.listener.actorCreated(this);
    }

    void moveInDirectionOf(Point target) {
        Point newLoc = local.add( local.dirTo(target) );
        moveTo( newLoc );
    }

    void moveTo(Point to) {
        Point old = local;
        local = to;
        if (model.listener!=null)
            model.listener.actorMoved(old,this);
    }

    public void moveToHero(Point heroPos) { }

    public Point getLocal() { return local; }

    protected void destroy() { }
}
