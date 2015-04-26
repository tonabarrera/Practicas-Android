package edu.ipn.cecyt9.practica10drawable;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

// ejemplo BitmapDrawable
/*public class MainActivity extends Activity {
    EjemploView ejemploView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ejemploView = new EjemploView(this);
        setContentView(ejemploView);
    }

    public class EjemploView extends View
    {
       private Drawable miImagen;

        public EjemploView (Context context)
        {
            super(context);
            Resources res = context.getResources();
            miImagen = res.getDrawable(R.drawable.mi_imagen);
            if (miImagen != null) {
                miImagen.setBounds(30,30,200,200);
            }else{
                Toast.makeText(context, "Algo salio mal", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        protected void onDraw(Canvas canvas)
        {
            miImagen.draw(canvas);
        }
    }
}*/

/*public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ImageView image = new ImageView(this);
        Drawable bitmapDrawable = getResources().getDrawable(R.drawable.mi_imagen);
        image.setImageDrawable(bitmapDrawable);
        setContentView(image);
    }
}*/


// ejemplo GradientDrawable
/*public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ImageView image = new ImageView(this);
        GradientDrawable gradientEjemplo = (GradientDrawable) getResources().getDrawable(R.drawable.degradado);
        image.setImageDrawable(gradientEjemplo);
        setContentView(image);
    }
}*/

//ejemplo TransitionDrawable
/*public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ImageView image = new ImageView(this);
        TransitionDrawable transition = (TransitionDrawable)
                getResources().getDrawable(R.drawable.transicion);
        transition.startTransition(2000);
        image.setImageDrawable(transition);
        setContentView(image);
    }
}*/

// ejemplo ShapeDrawable
/*public class MainActivity extends Activity {
    EjemploView ejemploView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ejemploView = new EjemploView(this);
        setContentView(ejemploView);
    }

    public class EjemploView extends View {

        private ShapeDrawable miImagen;

        public EjemploView (Context context) {
            super(context);

            miImagen  = new ShapeDrawable(new OvalShape());
            miImagen.getPaint().setColor(0xff0000ff);
            miImagen.setBounds(10, 10, 310, 60);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            miImagen.draw(canvas);
        }
    }
}*/

// ejemplo AnimationDrawable
public class MainActivity extends Activity {
    AnimationDrawable animacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        animacion = (AnimationDrawable)getResources().getDrawable(
                R.drawable.animacion);
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
