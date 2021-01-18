package pt.isel.poo.escape.view;

import android.graphics.Canvas;

import pt.isel.poo.escape.R;
import pt.isel.poo.tile.Img;

public class JunkTile extends ActorTile {
    private final static Img junkImg= new Img(context, R.drawable.junk);;

    @Override
    public void draw(Canvas canvas, int side) {
        junkImg.draw(canvas,side,side,paint);
    }
}
