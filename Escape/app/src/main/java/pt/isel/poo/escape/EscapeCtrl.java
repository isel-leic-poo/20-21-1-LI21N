package pt.isel.poo.escape;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Iterator;

import pt.isel.poo.escape.model.Actor;
import pt.isel.poo.escape.model.Escape;
import pt.isel.poo.escape.model.EscapeListener;
import pt.isel.poo.escape.model.Hero;
import pt.isel.poo.escape.model.Junk;
import pt.isel.poo.escape.model.Point;
import pt.isel.poo.escape.model.Robot;
import pt.isel.poo.escape.view.ActorTile;
import pt.isel.poo.escape.view.HeroTile;
import pt.isel.poo.escape.view.JunkTile;
import pt.isel.poo.escape.view.RobotTile;
import pt.isel.poo.tile.OnTileTouchListener;
import pt.isel.poo.tile.Tile;
import pt.isel.poo.tile.TilePanel;

public class EscapeCtrl extends AppCompatActivity {
    public static final int LINES = 16;
    public static final int COLS = 12;

    Escape model = new Escape(LINES,COLS);
    TilePanel panel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escape_layout);
        ActorTile.setContext(this);
        panel = findViewById(R.id.panel);
        panel.setSize(COLS,LINES);
        model.setListener( new EscapeListener() {
            @Override
            public void actorMoved(Point old, Actor actor) {
                Tile t = panel.getTile(old.col, old.line);
                panel.setTile(old.col,old.line,null);
                Point pos = actor.getLocal();
                panel.setTile(pos.col,pos.line, t);
            }
            @Override
            public void actorCreated(Actor actor) {
                Point pos = actor.getLocal();
                panel.setTile(pos.col,pos.line, createTile(actor));
            }
        });
        model.startNextLevel();

        panel.setListener(new OnTileTouchListener() {
            @Override
            public boolean onClick(int xTile, int yTile) {
                model.moveHeroInDirectionOf( new Point(yTile,xTile) );
                return true;
            }
            @Override
            public boolean onDrag(int xFrom, int yFrom, int xTo, int yTo) { return false; }
            @Override
            public void onDragEnd(int x, int y) { }
            @Override
            public void onDragCancel() { }
        });
    }

    private ActorTile createTile(Actor actor) {
        if (actor instanceof Hero)
            return new HeroTile();
        if (actor instanceof Robot)
            return new RobotTile();
        if (actor instanceof Junk)
            return new JunkTile();
        return null;
    }

    /*
    private void updateView() {
        for(int x=0 ; x < panel.getWidthInTiles() ; ++x)
            for(int y=0 ; y<panel.getHeightInTiles() ; ++y)
                panel.setTile(x,y,null);
        Hero h = model.getHero();
        Point hp = h.getLocal();
        panel.setTile(hp.col,hp.line, new HeroTile());
        Iterator<Robot> itr = model.getRobots();
        while ( itr.hasNext() ) {
            Robot r = itr.next();
            Point rp = r.getLocal();
            panel.setTile(rp.col,rp.line, new RobotTile());
        }
    }
     */
}