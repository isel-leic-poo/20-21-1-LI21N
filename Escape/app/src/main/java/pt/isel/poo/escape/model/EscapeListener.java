package pt.isel.poo.escape.model;

public interface EscapeListener {
    void actorMoved(Point old, Actor actor);
    void actorCreated(Actor actor);
}
