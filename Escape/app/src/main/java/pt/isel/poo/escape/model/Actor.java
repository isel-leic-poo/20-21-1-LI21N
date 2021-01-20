package pt.isel.poo.escape.model;

public class Actor {
    Point local;
    Escape game;
    protected Actor(Escape m, Point local) {
        this.local = local;
        game = m;
        game.actors.add(this);
        if (game.listener!=null)
            game.listener.actorCreated(this);
    }

    void moveInDirectionOf(Point target) {
        Point newLoc = local.add( local.dirTo(target) );
        moveTo( newLoc );
    }

    void moveTo(Point to) {
        Point old = local;
        local = to;
        if (game.listener!=null)
            game.listener.actorMoved(old,this);
    }

    public void moveToHero(Point heroPos) { }

    public Point getLocal() { return local; }

    protected void destroy() {
        game.actors.remove(this);
        if (game.listener!=null)
            game.listener.actorRemoved(this);
    }
}
