package edu.ipn.cecyt9.practica14hilos;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private EditText entrada;
    private TextView salidaFactorial;
    private TextView salidaSerie;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entrada = (EditText) findViewById(R.id.entrada);
        salidaFactorial = (TextView) findViewById(R.id.salida_factorial);
        salidaSerie = (TextView) findViewById(R.id.salida_serie);
    }

    public void calcularOperacion(View view) {
        int n = Integer.parseInt(entrada.getText().toString());
        salidaFactorial.append("\n" + n +"! = ");
        salidaSerie.append("\n" + n +" = ");

        MiTarea  tarea = new MiTarea();
        SerieHilo serieHilo = new SerieHilo();
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

    class SerieHilo extends AsyncTask<Integer, Void, Integer> {

        @Override
        protected Integer doInBackground(Integer... params) {
            int var = 1;
            int resultado = 0;
            for(int i = 0; i < params[0]; i++){
                resultado = resultado + var;
                var = resultado - var;
            }
            return resultado;
        }

        @Override
        protected void onPostExecute(Integer resultado) {
            salidaSerie.append(String.valueOf(resultado));
        }
    }
}
