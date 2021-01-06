package pt.isel.poo.counter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class BallView extends View {
    private static final float FACTOR_VALUE = 1.5f; // %
    private final Paint p = new Paint();
    private int value = 0;

    public BallView(Context context) {
        this(context,null);
    }
    public BallView(Context ctx, AttributeSet attrs) {
        super(ctx,attrs);
        p.setStyle(Paint.Style.FILL);
        p.setStrokeWidth(10);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int yMiddle = getHeight()/2;
        // y = H/2 - value * F/100 * H
        // value = - (y - H/2) / (F/100 *H)
        int y = (int) (yMiddle - value * (FACTOR_VALUE/100f *getHeight()));
        p.setColor(Color.RED);
        canvas.drawCircle(getWidth()/2,y,getWidth()/4,p);
        p.setColor(Color.BLACK);
        canvas.drawLine(0,yMiddle,getWidth(),yMiddle,p);
    }

    public void setValue(int val) {
        value = val;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action==MotionEvent.ACTION_DOWN || action==MotionEvent.ACTION_MOVE) {
            int h = getHeight();
            value = (int) (-( event.getY() - h/2 ) / (FACTOR_VALUE/100f * h));
            invalidate();
            if (listener!=null) listener.onMove(value);
            return true;
        }
        return false;
    }

    public interface OnMoveListener {
        void onMove(int val);
    }
    private OnMoveListener listener = null;

    public void setOnMoveListener(OnMoveListener l) {
        listener = l;
    }
}
