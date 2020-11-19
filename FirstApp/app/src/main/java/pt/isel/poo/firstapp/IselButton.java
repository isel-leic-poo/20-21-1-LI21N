package pt.isel.poo.firstapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

@SuppressLint({"AppCompatCustomView", "SetTextI18n"})
public class IselButton extends Button {
    public IselButton(Context context) {
        super(context);
        setText("ISEL");
        setTextSize(64f);
        setTextColor(Color.RED);
    }
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN)
            Log.d(MainActivity.TAG,"Touched");
        return super.onTouchEvent(event);
    }
}
