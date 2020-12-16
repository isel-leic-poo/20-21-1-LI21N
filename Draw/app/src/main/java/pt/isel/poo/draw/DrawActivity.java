package pt.isel.poo.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import pt.isel.poo.draw.model.Picture;

public class DrawActivity extends AppCompatActivity {

    public static final String FILE_NAME = "picture.txt";
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
        load.setOnClickListener( v -> load() );
        view.setModel(model);
    }
    private void load() {
        try (Scanner s = new Scanner(openFileInput(FILE_NAME))) {
            model.load(s);
            view.invalidate();
        }catch (IOException ex) {
            Log.e("DRAW","Error reading file",ex);
            Toast.makeText(this,"Error reading",Toast.LENGTH_LONG).show();
        }
    }

    private void save() {
        try (BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(
                openFileOutput(FILE_NAME, Activity.MODE_PRIVATE)
            ))) {
            model.save(bw);
        } catch (IOException ex) {
            Log.e("DRAW","Error creating file",ex);
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