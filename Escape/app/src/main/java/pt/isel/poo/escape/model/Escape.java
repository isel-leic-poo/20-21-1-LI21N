package pt.isel.poo.escape.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Escape {
    public static final int ROBOTS_FACTOR = 8;
    private final int lines;
    private final int cols;
    private Hero hero;
    private List<Robot> robots = new LinkedList<>();
    private int level = 0;

    public Escape(int lines, int cols) {
        this.lines = lines;
        this.cols = cols;
    }

    public void startNextLevel() {
        ++level;
        for(int r = 0; r < level*ROBOTS_FACTOR ; ++r) {
            robots.add( new Robot( freePosition() ) );
        }
        hero = new Hero( freePosition() );
    }

    public void moveHeroInDirectionOf( Point target ) {
        hero.move(target);
        for (Robot r : robots)
            r.move( hero.local );
    }

    private Point freePosition() {
        Point p;
        Random rnd = new Random();
        do {
            p = new Point( rnd.nextInt(lines) , rnd.nextInt(cols) );
        } while( exitsActorIn(p) );
        return p;
    }

    private boolean exitsActorIn(Point p) {
        for (Robot r : robots)
            if (r.local.equals(p)) return true;
        return false;
    }
}
