package pt.isel.poo.escape.view;

import android.content.Context;
import android.graphics.Canvas;

import pt.isel.poo.escape.R;
import pt.isel.poo.tile.Img;

public class HeroTile extends ActorTile {
    private final static Img heroImg= new Img(context, R.drawable.man);;

    @Override
    public void draw(Canvas canvas, int side) {
        heroImg.draw(canvas,side,side,paint);
    }
}
