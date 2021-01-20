package pt.isel.poo.escape.model;

public class Hero extends Actor {
    Hero(Escape m, Point local) {
        super(m,local);
    }

    @Override
    void moveInDirectionOf(Point target) {
        if (target.equals(local)) return;
        super.moveInDirectionOf(target);
    }

    @Override
    void moveTo(Point to) {
        Actor a = game.getActor(to);
        if ( a != null ) {
            destroy();
            return;
        }
        super.moveTo(to);
    }

    @Override
    protected void destroy() {
        if (game.listener!=null)
            game.listener.gameOver(false);
    }
}
