/*
AUTOR: Barrera Pérez Carlos Tonatihu
VERSION: 2.0
DESCRIPCION: Esta es una animacion de 5 sprites
OBSERVACIONES: Solo se agregaron nuevas images al codigo ya hecho
EJECUCION: Solo se da click en el boton 'run app', shift + F10 o click en la pestaña 'Run' y después
        click en 'Run App' y se selecciona el emulador o un dispositivo android.
*/

package edu.ipn.cecyt9.practica10drawable;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class SecondActivity extends Activity {

    AnimationDrawable animacion; //Declaramos nuestro AnimationDrawable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Obtenemos nuestra animacion xml
        animacion = (AnimationDrawable)getResources().getDrawable(
                R.drawable.mi_animacion);
        //Creamos un imageView
        ImageView vista = new ImageView(this);
        vista.setBackgroundColor(Color.WHITE);
        //Le pasamos nuestra animacion al ImageView
        vista.setImageDrawable(animacion);
        //Cuando detecta un click empieza la animacion
        vista.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                animacion.start();

            }
        });
        //Establecemos nuestra vista en la actividad
        setContentView(vista);
    }
}
