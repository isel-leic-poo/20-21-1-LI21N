package pt.isel.poo.escape.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Escape {
    public static final int ROBOTS_FACTOR = 2;
    private final int lines;
    private final int cols;
    private Hero hero;
    List<Actor> actors = new LinkedList<>();
    private int level = 0;

    public Escape(int lines, int cols) {
        this.lines = lines;
        this.cols = cols;
    }

    public void startNextLevel() {
        ++level;
        actors.clear();
        for(int r = 0; r < level*ROBOTS_FACTOR ; ++r) {
            new Robot(this, freePosition() );
        }
        hero = new Hero(this, freePosition() );
    }

    public void moveHeroInDirectionOf( Point target ) {
        if (hero.isDead()) return;
        hero.moveInDirectionOf(target);
        LinkedList<Actor> moves = new LinkedList<>();
        for (Actor a : actors)
            if (a.isMovableToHero()) moves.add(a);
        for (Actor a : moves) actors.remove(a);
        for (Actor a : moves) a.moveToHero(hero.local);
    }
    public void jumpHero() {
        hero.moveTo( freePosition() );
    }

    public Hero getHero() { return hero; }
    public Iterator<Actor> getActors() { return actors.iterator(); }

    private Point freePosition() {
        Point p;
        Random rnd = new Random();
        do {
            p = new Point( rnd.nextInt(lines) , rnd.nextInt(cols) );
        } while( exitsActorIn(p) );
        return p;
    }

    private boolean exitsActorIn(Point p) {
        return getActor(p)!=null;
    }

    EscapeListener listener;

    public void setListener(EscapeListener listener) {
        this.listener = listener;
    }
    public Actor getActor(Point to) {
        for (Actor a : actors)
            if (a.local.equals(to)) return a;
        return null;
    }
}
