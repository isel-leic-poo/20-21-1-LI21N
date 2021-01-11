package pt.isel.poo.escape;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import pt.isel.poo.escape.view.ActorTile;
import pt.isel.poo.escape.view.HeroTile;
import pt.isel.poo.escape.view.RobotTile;
import pt.isel.poo.tile.Img;
import pt.isel.poo.tile.Tile;
import pt.isel.poo.tile.TilePanel;

public class EscapeCtrl extends AppCompatActivity {

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
    }
}