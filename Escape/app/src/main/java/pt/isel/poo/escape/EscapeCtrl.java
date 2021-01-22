package pt.isel.poo.escape;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import pt.isel.poo.escape.model.*;
import pt.isel.poo.escape.view.*;
import pt.isel.poo.tile.OnTileTouchListener;
import pt.isel.poo.tile.Tile;
import pt.isel.poo.tile.TilePanel;

public class EscapeCtrl extends AppCompatActivity {
    public static final int LINES = 16;
    public static final int COLS = 12;

    Escape model = new Escape(LINES,COLS);
    TilePanel panel;
    Button nextLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escape_layout);
        ActorTile.setContext(this);
        panel = findViewById(R.id.panel);
        panel.setSize(COLS,LINES);
        model.setListener( viewUpdater );
        model.startNextLevel();
        panel.setListener(clickListener);
        findViewById(R.id.jump).setOnClickListener( v -> model.jumpHero() );
        nextLevel = findViewById(R.id.next);
        nextLevel.setOnClickListener( v -> startNextLevel() );
        nextLevel.setVisibility( View.INVISIBLE );
    }

    private EscapeListener viewUpdater = new EscapeListener() {
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
        @Override
        public void actorRemoved(Actor actor) {
            Point pos = actor.getLocal();
            panel.setTile(pos.col,pos.line, null);
        }
        @Override
        public void gameOver(boolean win) {
            String txt = getString(win? R.string.win : R.string.over);
            Toast.makeText(EscapeCtrl.this,txt,Toast.LENGTH_LONG).show();
            if (!win) {
                Point pos = model.getHero().getLocal();
                panel.setTile(pos.col,pos.line, new DeadTile());
            } else
                nextLevel.setVisibility(View.VISIBLE);
        }
    };

    private OnTileTouchListener clickListener = new OnTileTouchListener() {
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
    };

    private ActorTile createTile(Actor actor) {
        if (actor instanceof Hero)
            return new HeroTile();
        if (actor instanceof Robot)
            return new RobotTile();
        if (actor instanceof Junk)
            return new JunkTile();
        return null;
    }

    private void startNextLevel() {
        for(int x=0 ; x < panel.getWidthInTiles() ; ++x)
            for(int y=0 ; y<panel.getHeightInTiles() ; ++y)
                panel.setTile(x,y,null);
        model.startNextLevel();
        nextLevel.setVisibility(View.INVISIBLE);
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