package pt.isel.poo.escape.model;

public class Robot extends Actor {
    private static int numOfRobots = 0;

    Robot(Escape m, Point local) {
        super(m,local);
        ++numOfRobots;
    }

    @Override
    void moveTo(Point to) {
        Actor a = game.getActor(to);
        if ( a instanceof Robot ) {
            a.destroy();
            destroy();
            new Junk(game,to);
            return;
        }
        if ( a instanceof Junk ) {
            destroy();
            return;
        }
        if ( a instanceof Hero ) {
            a.destroy();
            return;
        }
        super.moveTo(to);
        game.actors.add(this);
    }

    @Override
    public void moveToHero(Point heroPos) {
        moveInDirectionOf(heroPos);
    }

    @Override
    protected void destroy() {
        super.destroy();
        --numOfRobots;
        if (numOfRobots == 0)
            if (game.listener != null)
                game.listener.gameOver(true);
    }

    @Override
    public boolean isMovableToHero() { return true; }
}
