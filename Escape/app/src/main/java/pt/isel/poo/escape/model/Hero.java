package pt.isel.poo.escape.model;

public class Hero extends Actor {
    private boolean dead = false;
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
        if (dead) return;
        Actor a = game.getActor(to);
        if ( a != null ) {
            destroy();
            return;
        }
        super.moveTo(to);
    }

    @Override
    protected void destroy() {
        dead = true;
        if (game.listener!=null)
            game.listener.gameOver(false);
    }
    public boolean isDead() { return dead; }
}
