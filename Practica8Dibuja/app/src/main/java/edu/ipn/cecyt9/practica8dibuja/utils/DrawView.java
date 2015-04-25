/*
AUTOR: Barrera Pérez Carlos Tonatihu
VERSION: 2.0
DESCRIPCION: Este programa junta la practica 8 que dibuja distintas figuras
OBSERVACIONES: A esta version se le agregaron nuevas figuras, un triangulo, pentagono y un hexagono
COMPILACION: Se conpila cuando se ejecuta
EJECUCION: Solo se da click en el boton 'run app', shift + F10 o click en la pestaña 'Run' y después
        click en 'Run App' y se selecciona el emulador o un dispositivo android.
*/

package edu.ipn.cecyt9.practica8dibuja.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.view.View;

import edu.ipn.cecyt9.practica8dibuja.R;

/**
 * Created by iLordTony on 24/04/2015.
 */
public class DrawView extends View {

    //Declaramos los paths de cada figura y el paint para dar estilos
    private Paint paint;
    private Path trazo;
    private Path trazoTriangulo;
    private Path trazoHexagono;
    private Path trazoPentagono;
    //Inicializamos las variables en nuestro contructor
    public DrawView(Context context){
        super(context);
        paint = new Paint();
        trazo = new Path();
        trazoTriangulo = new Path();
        trazoHexagono = new Path();
        trazoPentagono = new Path();
    }
    //con este metodo dibujasmos
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //.drawRect(left, top, right, bottom, paint)
        paint.setColor(Color.RED);
        canvas.drawRect(30, 30, 80, 80, paint);

        paint.setColor(Color.CYAN);
        canvas.drawRect(33, 60, 77, 77, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawRect(33, 33, 77, 60, paint);

        //.drawCircle(cx, cy, radius, paint);
        paint.setColor(Color.RED);
        canvas.drawCircle(100, 100, 20, paint);

        //recupero una cadena de texto
        String textCanvas = getContext().getString(R.string.texto_canvas);
        //.drawText(text, x, y, paint)
        canvas.drawText(textCanvas, 200, 30, paint);

        //.drawLine(startX, startY, stopX, stopY, paint)
        paint.setColor(Color.BLUE);
        canvas.drawLine(0, 0, 350, 100, paint);


        String nombreEscuela = getContext().getString(R.string.escuela_name);
        trazo.addCircle(150, 450, 100, Path.Direction.CCW);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(trazo, paint);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(20f);
        paint.setTypeface(Typeface.SANS_SERIF);
        canvas.drawTextOnPath(nombreEscuela, trazo, 150, 40, paint);
        //se ejecutan los metodos de para dibujar las figuras
        dibujaHexagono(canvas);
        dibujaTriangulo(canvas);
        dibuarPentagono(canvas);
    }

    public void dibujaTriangulo(Canvas canvas){
        //definimos algunos estilos
        paint.reset();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);
        /*
        con moveTo() ubicamos nuestro pincel en un punto y despues
        con lineTo() dibujamos una linea desde ese punto
        */
        trazoTriangulo.moveTo(150, 100);
        trazoTriangulo.lineTo(250, 200);
        trazoTriangulo.moveTo(250, 200);
        trazoTriangulo.lineTo(150, 200);
        trazoTriangulo.moveTo(150, 200);
        trazoTriangulo.lineTo(150, 100);
        trazoTriangulo.close();//Cerramos la figura
        canvas.drawPath(trazoTriangulo, paint); //Se dibuja la figura
    }

    public void dibujaHexagono(Canvas canvas){
        float radio = 50;
        //Estas dos variables son el centro del hexagono
        float centroX = 400;
        float centroy = 200;
        float apotema = (float)(radio * Math.sqrt(3) / 2); //Calculamos el apotema

        paint.reset();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);
        //Haciendo algunos calculos tenemos la figura con esta serie de codigo
        trazoHexagono.moveTo(centroX, centroy - radio);
        trazoHexagono.lineTo(centroX + apotema, centroy - radio / 2);
        trazoHexagono.moveTo(centroX + apotema, centroy - radio / 2);
        trazoHexagono.lineTo(centroX + apotema, centroy + radio / 2);
        trazoHexagono.moveTo(centroX + apotema, centroy + radio / 2);
        trazoHexagono.lineTo(centroX, centroy + radio);
        trazoHexagono.moveTo(centroX, centroy + radio);
        trazoHexagono.lineTo(centroX - apotema, centroy + radio / 2);
        trazoHexagono.moveTo(centroX - apotema, centroy + radio / 2);
        trazoHexagono.lineTo(centroX - apotema, centroy - radio / 2);
        trazoHexagono.moveTo(centroX - apotema, centroy - radio / 2);
        trazoHexagono.lineTo(centroX, centroy - radio);
        trazoHexagono.close(); //Cerramos la figura
        canvas.drawPath(trazoHexagono, paint);//Se dibuja la figura
    }
    public void dibuarPentagono(Canvas canvas){
        float radio = 50;
        //Estas dos variables son el centro del pentagono
        float centroX = 400;
        float centroy = 400;
        float apotema = (float)(radio * Math.sqrt(3) / 2); //calculamos el apotema

        paint.reset();
        paint.setColor(Color.DKGRAY);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);
        //Haciendo algunos calculos tenemos la figura con esta serie de codigo
        trazoPentagono.moveTo(centroX, centroy - radio);
        trazoPentagono.lineTo(centroX + radio, centroy - 10);
        trazoPentagono.moveTo(centroX + radio, centroy - 10);
        trazoPentagono.lineTo(centroX + apotema / 2, centroy + apotema);
        trazoPentagono.moveTo(centroX + apotema / 2, centroy + apotema);
        trazoPentagono.lineTo(centroX - apotema / 2, centroy + apotema);
        trazoPentagono.moveTo(centroX - apotema / 2, centroy + apotema);
        trazoPentagono.lineTo(centroX - radio, centroy - 10);
        trazoPentagono.moveTo(centroX - radio, centroy - 10);
        trazoPentagono.lineTo(centroX, centroy - radio);
        trazoPentagono.close();//Cerramos la figura
        canvas.drawPath(trazoPentagono, paint); //Se dibuja la figura
    }
}
