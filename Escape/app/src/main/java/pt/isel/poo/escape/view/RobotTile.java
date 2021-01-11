package pt.isel.poo.escape.view;

import android.content.Context;
import android.graphics.Canvas;

import pt.isel.poo.escape.R;
import pt.isel.poo.tile.Img;

public class RobotTile extends ActorTile {
    private final static Img robotImg= new Img(context, R.drawable.robot);

    @Override
    public void draw(Canvas canvas, int side) {
        robotImg.draw(canvas,side,side,paint);
    }
}
