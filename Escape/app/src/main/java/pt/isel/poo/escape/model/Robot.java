package pt.isel.poo.escape.model;

public class Robot extends Actor {
    Robot(Escape m, Point local) {
        super(m,local);
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
    }

    @Override
    public void moveToHero(Point heroPos) {
        moveInDirectionOf(heroPos);
    }
}
