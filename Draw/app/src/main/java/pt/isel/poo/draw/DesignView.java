package pt.isel.poo.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import pt.isel.poo.draw.model.Picture;
import pt.isel.poo.draw.model.Point;

public class DesignView extends View {
    private final Paint p = new Paint();
    private Picture model;

    public DesignView(Context ctx) {
        super(ctx);
        p.setColor(Color.BLACK);
        p.setStrokeWidth(5F);
        p.setStrokeCap(Paint.Cap.ROUND);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            Point pt = model.getStart();
            for(Point end : model) {
                canvas.drawLine(pt.x,pt.y,end.x,end.y,p);
                pt = end;
            }
        } catch ( NullPointerException e ) {
            Log.v("DRAW","Empty segment.");
            Toast.makeText(getContext(),"Empty",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int a = event.getAction();
        if (a==MotionEvent.ACTION_DOWN || a==MotionEvent.ACTION_MOVE) {
            Point pt = new Point( (int)event.getX(), (int)event.getY() );
            if (a==MotionEvent.ACTION_DOWN) model.setStart(pt);
            else model.add(pt);
            invalidate();
            return true;
        }
        return super.onTouchEvent(event);
    }

    public void setModel(Picture model) {
        this.model = model;
        invalidate();
    }
}
