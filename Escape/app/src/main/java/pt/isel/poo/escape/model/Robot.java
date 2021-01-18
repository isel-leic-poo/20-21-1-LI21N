package pt.isel.poo.escape.model;

public class Robot extends Actor {
    Robot(Escape m, Point local) {
        super(m,local);
    }

    @Override
    void moveTo(Point to) {
        Actor a = model.getActor(to);
        if ( a instanceof Robot ) {
            a.destroy();
            destroy();
            new Junk(model,to);
            return;
        }
        super.moveTo(to);
    }

    @Override
    public void moveToHero(Point heroPos) {
        moveInDirectionOf(heroPos);
    }
}
