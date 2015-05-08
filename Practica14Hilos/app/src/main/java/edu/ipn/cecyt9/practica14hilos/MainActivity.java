/*
AUTOR: Barrera Pérez Carlos Tonatihu

VERSION: 2.0

DESCRIPCION: Este programa junta la practica 14 en la que se usan hilos, especificanmente la clase AsyncTask

OBSERVACIONES: En la primera version solo se calculaba el factorial de un numero, en esta version se calcula un numero en la serie de fibonacci en base a su posicion

COMPILACION: Se compila cuando se ejecuta

EJECUCION: Solo se da click en el boton 'run app', shift + F10 o click en la pestaña 'Run' y después
        click en 'Run App' y se selecciona el emulador o un dispositivo android.
*/

package edu.ipn.cecyt9.practica14hilos;
//importamos las librerias necesarias
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    //Declaramos los elementos que vamos a usar 
    private EditText entrada;
    private TextView salidaFactorial;
    private TextView salidaSerie;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inicializamos nuestros elementos
        entrada = (EditText) findViewById(R.id.entrada);
        salidaFactorial = (TextView) findViewById(R.id.salida_factorial);
        salidaSerie = (TextView) findViewById(R.id.salida_serie);
    }
    //Este metodo se ejecuta cuando se pulsa el boton de calcular
    public void calcularOperacion(View view) {
        int n = Integer.parseInt(entrada.getText().toString());//Recuperamos el num a ser calculado
        salidaFactorial.append("\n" + n +"! = ");
        salidaSerie.append("\n" + n +" = ");
        //Creamos nuestros objetos
        MiTarea  tarea = new MiTarea();
        SerieHilo serieHilo = new SerieHilo();
        //Ejecutamos nuestros hilos y les pasamos el numero con el que se va a calcular el factorial y el numero de la serie
        serieHilo.execute(n);
        tarea.execute(n);
    }

    class MiTarea extends AsyncTask<Integer, Void, Integer> {

        @Override
        protected Integer doInBackground(Integer... n) {
            int res = 1;

            for (int i = 1; i <= n[0]; i++) {
                res *= i;
                SystemClock.sleep(1000);
            }
            return res;
        }

        @Override
        protected void onPostExecute(Integer res) {
            salidaFactorial.append(String.valueOf(res));
        }
    }
    //Creamos una clase que herede de AsyncTask y que va a utilizar datos de tipo Integer
    class SerieHilo extends AsyncTask<Integer, Void, Integer> {
        //Sobrecargamos nuestro metodo y en este recibe el numero que le pasamos
        @Override
        protected Integer doInBackground(Integer... params) {
            int var = 1;
            int resultado = 0;
            //con este loop calculamos el resultado de la serie se fibonacci
            for(int i = 0; i < params[0]; i++){
                resultado = resultado + var;
                var = resultado - var;
            }
            return resultado; //Retornamos el resultado de tipo Integer
        }
        //Sobrecargamos y aqui se recibe el valor que se retorna y que es del mismo tipo
        @Override
        protected void onPostExecute(Integer resultado) {
            salidaSerie.append(String.valueOf(resultado)); //Solo añadimos el resultado al TextView
        }
    }
}
