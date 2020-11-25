package pt.isel.poo.counter;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CounterActivity extends Activity { // Ctrl

    TextView value;          // View
    Button reset, inc, dec;  // View
    BallView ball;           // View
    Counter model = new Counter(); // Model

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = initView();
        initListeners();
        setContentView(root);
    }

    private void initListeners() {
        reset.setOnClickListener( v-> { model.reset(); updateView(); });
        inc.setOnClickListener( v-> { model.inc(); updateView(); });
        dec.setOnClickListener( v-> { model.dec(); updateView(); });
    }

    private void updateView() {
        value.setText(Integer.toString(model.getValue()));
    }

    private View initView() {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        LinearLayout buttons = new LinearLayout(this);
        buttons.setOrientation(LinearLayout.HORIZONTAL);

        value = new TextView(this);
        value.setTextSize(64f);
        value.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        value.setText("0");
        value.setBackgroundColor(Color.LTGRAY);
        reset = new Button(this);
        reset.setText("0");
        inc = new Button(this);
        inc.setText("+");
        dec = new Button(this);
        dec.setText("-");
        ball = new BallView(this);

        root.addView(value);
        root.addView(buttons);
        buttons.addView(reset);
        buttons.addView(inc);
        buttons.addView(dec);
        root.addView(ball);

        return root;
    }
}