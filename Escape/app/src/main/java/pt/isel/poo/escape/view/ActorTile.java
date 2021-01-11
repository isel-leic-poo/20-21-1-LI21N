package pt.isel.poo.escape.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;

import pt.isel.poo.tile.Tile;

public abstract class ActorTile implements Tile {
    protected static final Paint paint = new Paint();
    @SuppressLint("StaticFieldLeak")
    protected static Context context;
    public static void setContext(Context ctx) { context = ctx; }
    @Override
    public boolean setSelect(boolean selected) { return false; }
}
