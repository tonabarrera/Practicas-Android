package edu.ipn.cecyt9.practica10drawable;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class SecondActivity extends Activity {

    AnimationDrawable animacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animacion = (AnimationDrawable)getResources().getDrawable(
                R.drawable.mi_animacion);
        ImageView vista = new ImageView(this);
        vista.setBackgroundColor(Color.WHITE);
        vista.setImageDrawable(animacion);
        vista.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                animacion.start();

            }
        });
        setContentView(vista);
    }
}
