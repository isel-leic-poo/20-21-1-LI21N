package pt.isel.poo.counter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class BallView extends View {
    private final Paint p = new Paint();

    public BallView(Context context) {
        super(context);
        p.setStyle(Paint.Style.FILL);
        p.setStrokeWidth(10);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int y = getHeight()/2;
        p.setColor(Color.RED);
        canvas.drawCircle(getWidth()/2,y,getWidth()/4,p);
        p.setColor(Color.BLACK);
        canvas.drawLine(0,y,getWidth(),y,p);
    }
}
