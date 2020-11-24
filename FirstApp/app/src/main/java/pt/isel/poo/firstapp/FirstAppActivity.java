package pt.isel.poo.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FirstAppActivity extends AppCompatActivity  {

    public static final String TAG = "FirstApp";
    private Button ok, isel;
    private TextView txt;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate:"+hashCode());
        super.onCreate(savedInstanceState);

        isel = new Button(this);
        isel.setText("ISEL");
        //isel.setTextSize(64f);
        isel.setTextColor(Color.RED);
        isel.setOnClickListener( x -> txt.setText("ISEL") );

        ok = new Button(this);
        ok.setText("OK");
        //ok.setTextSize(64f);
        ok.setOnClickListener( v -> finish() );

        txt = new TextView(this);
        txt.setText("Hello POO");
        txt.setTextSize(32f);
        txt.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        txt.setBackgroundColor(Color.YELLOW);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.addView(txt);
        root.addView(isel);
        root.addView(ok);
        //root.setBackgroundColor(Color.MAGENTA);

        setContentView(root);
    }
}