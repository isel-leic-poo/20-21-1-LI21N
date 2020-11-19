package pt.isel.poo.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "FirstApp";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate:"+hashCode());
        super.onCreate(savedInstanceState);
        Button isel = new IselButton(this);
        isel.setOnClickListener(this);
        setContentView(isel);
    }
    @Override
    protected void onStart() {
        Log.d(TAG,"onStart");
        super.onStart();
    }
    @Override
    protected void onStop() {
        Log.d(TAG,"onStop");
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        Log.d(TAG,"onDestroy");
        super.onDestroy();
    }
    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        Log.d(TAG,"click: "+b.getText());
        finish();
    }
}