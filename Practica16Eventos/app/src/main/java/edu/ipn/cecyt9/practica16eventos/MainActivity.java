package edu.ipn.cecyt9.practica16eventos;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SpecialView miVista = new SpecialView(this);
        setContentView(miVista);
    }

    class SpecialView extends View {
        float x = 50;
        float radio = 50;
        float y = 50;
        String accion = "Accion";
        String texto = "Evento";
        Path path;
        Paint paint;

        public SpecialView(Context context) {
            super(context);
            path = new Path();
            paint = new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Log.e("Hola", "hola");
             // color de fondo
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(6);
            paint.setColor(Color.RED);

            if (accion.equals("down")) {
                path.addCircle(x, y, radio, Path.Direction.CCW);
            }
            if (accion.equals("move")) {
                path.addCircle(x, y, radio, Path.Direction.CCW);
            }
            canvas.drawPath(path, paint);
            paint.setColor(Color.BLACK);
            paint.setTextSize(20);
            paint.setStrokeWidth(2);
            canvas.drawText(texto, 100, 130, paint);
            canvas.drawText("x = " + x + "  y = " + y, 100, 50, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent evento) {
            x = evento.getX();
            y = evento.getY();

            if (evento.getAction() == MotionEvent.ACTION_DOWN) {
                accion = "down";
                texto = "Action Down";
            }
            if (evento.getAction() == MotionEvent.ACTION_UP) {
                texto = "Action Up";
            }
            if (evento.getAction() == MotionEvent.ACTION_MOVE) {
                accion = "move";
                texto = "Action Move";
            }
            invalidate();
            return true;
        }

    }
}
