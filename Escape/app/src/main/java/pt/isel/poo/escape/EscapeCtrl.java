package pt.isel.poo.escape;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import pt.isel.poo.escape.model.Escape;
import pt.isel.poo.escape.view.ActorTile;
import pt.isel.poo.escape.view.HeroTile;
import pt.isel.poo.escape.view.RobotTile;
import pt.isel.poo.tile.Img;
import pt.isel.poo.tile.OnTileTouchListener;
import pt.isel.poo.tile.Tile;
import pt.isel.poo.tile.TilePanel;

public class EscapeCtrl extends AppCompatActivity {
    public static final int LINES = 16;
    public static final int COLS = 12;

    Escape model = new Escape(LINES,COLS);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escape_layout);
        ActorTile.setContext(this);
        TilePanel panel = findViewById(R.id.panel);
        panel.setTile(1, 1, new RobotTile() );
        panel.setTile(6, 4, new RobotTile() );
        panel.setTile(8, 2, new RobotTile() );
        panel.setTile(5,5, new HeroTile() );
        panel.setListener(new OnTileTouchListener() {
            @Override
            public boolean onClick(int xTile, int yTile) {
                panel.setTile(xTile,yTile, new HeroTile());
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
}