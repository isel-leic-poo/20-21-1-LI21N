package pt.isel.poo.escape.view;

import android.graphics.Canvas;

import pt.isel.poo.escape.R;
import pt.isel.poo.tile.Img;

public class DeadTile extends ActorTile {
    private final static Img deadImg = new Img(context, R.drawable.dead);;

    @Override
    public void draw(Canvas canvas, int side) {
        deadImg.draw(canvas,side,side,paint);
    }
}
