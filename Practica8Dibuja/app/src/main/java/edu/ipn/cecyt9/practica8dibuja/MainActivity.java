/*
AUTOR: Barrera Pérez Carlos Tonatihu
VERSION: 2.0
DESCRIPCION: Este programa junta la practica 8 que dibuja distintas figuras
OBSERVACIONES: A esta version se le agregaron nuevas figuras, un triangulo, pentagono y un hexagono
COMPILACION: Se compila cuando se ejecuta
EJECUCION: Solo se da click en el boton 'run app', shift + F10 o click en la pestaña 'Run' y después
        click en 'Run App' y se selecciona el emulador o un dispositivo android.
*/

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
        setContentView(drawView); //Establecemos la vista que se va a mostrar, que nosotros creamos
    }
}
