package pt.isel.poo.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import pt.isel.poo.draw.model.Picture;

public class DrawActivity extends AppCompatActivity {

    Button clear, undo, save, load;
    DesignView view;
    Picture model = new Picture();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new DesignView(this);
        setContentView(initView());
        clear.setOnClickListener(v -> {model.clear(); view.setModel(model);});
        undo.setOnClickListener(v -> {model.removeLast(); view.invalidate();});
        save.setOnClickListener( v -> save() );
        view.setModel(model);
    }

    private void save() {
        try {
            FileOutputStream fos = openFileOutput("picture.txt", Activity.MODE_PRIVATE);
            model.save(fos);
            fos.close();
        } catch (IOException ex) {
            Log.e("DRAW","Error creating file",ex);
            ex.printStackTrace();
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
}