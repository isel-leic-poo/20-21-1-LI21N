package pt.isel.poo.draw;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import pt.isel.poo.draw.model.Picture;

public class DrawActivity extends AppCompatActivity {
    public static final String FILE_NAME = "picture.txt";
    public static final String TAG = "DRAW";
    public static final String KEY_MODEL = "Picture";

    Button clear, undo, save, load;
    DesignView view;
    Picture model = new Picture();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG,"onCreate("+savedInstanceState+")");
        view = new DesignView(this);
        setContentView(initView());
        clear.setOnClickListener(v -> {model.clear(); view.setModel(model);});
        undo.setOnClickListener(v -> {model.removeLast(); view.invalidate();});
        save.setOnClickListener( v -> save() );
        load.setOnClickListener( v -> load() );
        view.setModel(model);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.v(TAG,"onRestoreInstanceState");
        try (Scanner s = new Scanner(new ByteArrayInputStream(savedInstanceState.getByteArray(KEY_MODEL)))) {
            model.load(s);
        } catch (IOException ex) {
            Log.e(TAG,"Error in restore State.",ex);
        }
    }

    private void load() {
        try (Scanner s = new Scanner(openFileInput(FILE_NAME))) {
            model.load(s);
            view.invalidate();
        }catch (IOException ex) {
            Log.e(TAG,"Error reading file",ex);
            Toast.makeText(this,"Error reading",Toast.LENGTH_LONG).show();
        }
    }

    // https://videoconf-colibri.zoom.us/my/palex

    private void save() {
        try (BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(
                openFileOutput(FILE_NAME, Activity.MODE_PRIVATE)
            ))) {
            model.save(bw);
            bw.write(model.getClass().getSimpleName()); bw.newLine();
            Class<?> cls = Class.forName("pt.isel.poo.draw.model.Point");
            bw.write(cls.getName());
        } catch (IOException | ClassNotFoundException ex) {
            Log.e(TAG,"Error creating file",ex);
        }
    }

    private View initView() {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        LinearLayout bar = new LinearLayout(this);
        bar.setOrientation(LinearLayout.HORIZONTAL);
        clear = new Button(this);
        clear.setText("Clear All");
        undo = new Button(this);
        undo.setText("Clear Last");
        save = new Button(this);
        save.setText("Save");
        load = new Button(this);
        load.setText("Load");
        root.addView(bar);
        bar.addView(clear);
        bar.addView(undo);
        bar.addView(save);
        bar.addView(load);
        root.addView(view);
        bar.setBackgroundColor(Color.LTGRAY);
        return root;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v(TAG, "onSaveInstanceState");
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(baos));
            model.save(bw);
            bw.close();
            outState.putByteArray(KEY_MODEL,baos.toByteArray());
        } catch (IOException ex) {
            Log.e(TAG,"Error write in Bundle",ex);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"onDestroy");
    }
}