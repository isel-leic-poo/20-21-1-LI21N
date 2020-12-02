package pt.isel.poo.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import pt.isel.poo.draw.model.Picture;

public class DrawActivity extends AppCompatActivity {

    DesignView view;
    Picture model = new Picture();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new DesignView(this);
        setContentView(view);
        view.setModel(model);
    }
}