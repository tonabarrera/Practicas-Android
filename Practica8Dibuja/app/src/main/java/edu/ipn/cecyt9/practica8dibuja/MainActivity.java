package edu.ipn.cecyt9.practica8dibuja;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import edu.ipn.cecyt9.practica8dibuja.utils.DrawView;


public class MainActivity extends ActionBarActivity {

    DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawView = new DrawView(this);
        drawView.setBackgroundColor(Color.WHITE);
        setContentView(drawView);
    }
}
