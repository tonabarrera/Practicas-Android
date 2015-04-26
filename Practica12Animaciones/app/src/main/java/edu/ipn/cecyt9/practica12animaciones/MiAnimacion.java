package edu.ipn.cecyt9.practica12animaciones;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class MiAnimacion extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_animacion);

        TextView texto = (TextView) findViewById(R.id.text_titulo);
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.animacion);
        texto.startAnimation(animacion);

    }
}
