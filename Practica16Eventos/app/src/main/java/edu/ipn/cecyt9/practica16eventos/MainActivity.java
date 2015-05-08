/*
AUTOR: Barrera Pérez Carlos Tonatihu

VERSION: 2.0

DESCRIPCION: Este programa junta la practica 16 en la que se dibujan circulos con los dedos

OBSERVACIONES: La primera version se dibujaba una linea que seguia nuestro dedo, en esta version esa linea es rempladaza con un circulo

COMPILACION: Se compila cuando se ejecuta

EJECUCION: Solo se da click en el boton 'run app', shift + F10 o click en la pestaña 'Run' y después
        click en 'Run App' y se selecciona el emulador o un dispositivo android.
*/

package edu.ipn.cecyt9.practica16eventos;
//importamos lo necesario
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SpecialView miVista = new SpecialView(this);//Cremos nuestra vista perzonalizada pasandole
        setContentView(miVista); //Inflamos nuestra vista
    }
    //Esta sera nuestra vista especial, una clase que hereda de View
    class SpecialView extends View {
        float x = 50;
        float radio = 50; //Radio del circulo
        float y = 50;
        String accion = "Accion";
        String texto = "Evento";
        //Delaramos nuestro path y paint
        Path path;
        Paint paint;
        //Nuestro constructor
        public SpecialView(Context context) {
            super(context);
            path = new Path();
            paint = new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas) {
             // color de fondo
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(6);
            paint.setColor(Color.RED);
            //Se ejecuta cuando se pulsa la pantalla y dibuja un circulo
            if (accion.equals("down")) {
                path.addCircle(x, y, radio, Path.Direction.CCW);
            }
            //Se ejecuta cuando se mueve el dedo sobre la pantalla y dibuja un circulo
            if (accion.equals("move")) {
                path.addCircle(x, y, radio, Path.Direction.CCW);
            }
            //le pasamos nuestro trazo al canvas para que este lo dibuje
            canvas.drawPath(path, paint);
            paint.setColor(Color.BLACK);
            paint.setTextSize(20);
            paint.setStrokeWidth(2);
            canvas.drawText(texto, 100, 130, paint);
            canvas.drawText("x = " + x + "  y = " + y, 100, 50, paint);
        }
        //Con este metodo detectamos las acciones sobre la pantalla
        @Override
        public boolean onTouchEvent(MotionEvent evento) {
            //obtemeos las cordenadas
            x = evento.getX();
            y = evento.getY();
            //Es verdadera si se pulsa la pantalla
            if (evento.getAction() == MotionEvent.ACTION_DOWN) {
                accion = "down";
                texto = "Action Down";
            }
            //Es verdadera si se levanta el dedo de la pantalla
            if (evento.getAction() == MotionEvent.ACTION_UP) {
                texto = "Action Up";
            }
            //Es verdadera si se mueve el dedo sobre la pantalla
            if (evento.getAction() == MotionEvent.ACTION_MOVE) {
                accion = "move";
                texto = "Action Move";
            }
            invalidate();
            return true;
        }

    }
}
