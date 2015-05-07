/*
AUTOR: Barrera Pérez Carlos Tonatihu
VERSION: 2.0
DESCRIPCION: Esta aplicacion ejecuta una animacion a un texto y lo deja en un lugar fijo
OBSERVACIONES: Se cambiaron las animaciones tween por property
COMPILACION: Se compila cuando se ejecuta
EJECUCION: Solo se da click en el boton 'run app', shift + F10 o click en la pestaña 'Run' y después
        click en 'Run App' y se selecciona el emulador o un dispositivo android.
*/

package edu.ipn.cecyt9.practica12animaciones;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MiAnimacion extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_animacion);
        //Obtenemos nuestro texto
        TextView texto = (TextView) findViewById(R.id.text_titulo);
        //Creamos un AnimatorSet al que le cargamos nuestra animacion en xml
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.mi_animacion);
        set.setTarget(texto); //Le decimos a que objeto le va asignar la animacion
        set.start(); //Esto ejecuta la animacion
    }
    //Este metodo abre la actividad del codigo que ya estaba hecho
    public void onClickMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
