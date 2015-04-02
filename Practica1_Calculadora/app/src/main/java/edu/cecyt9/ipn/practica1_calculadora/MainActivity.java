package edu.cecyt9.ipn.practica1_calculadora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private EditText input_numero;
    private String contenido = "";
    private Double resultado, numero1, numero2;
    private String operacion = "";
    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        input_numero = (EditText) findViewById(R.id.input_numero);
    }

    public void onClickButtonCero(View view){
        contenido = input_numero.getText().toString() + "0";
        input_numero.setText(contenido);
    }

    public void onClickButtonUno(View view){
        contenido = input_numero.getText().toString() + "1";
        input_numero.setText(contenido);
    }

    public void onClickButtonDos(View view){
        contenido = input_numero.getText().toString() + "2";
        input_numero.setText(contenido);
    }

    public void onClickButtonTres(View view){
        contenido = input_numero.getText().toString() + "3";
        input_numero.setText(contenido);
    }

    public void onClickButtonCuatro(View view){
        contenido = input_numero.getText().toString() + "4";
        input_numero.setText(contenido);
    }

    public void onClickButtonCinco(View view){
        contenido = input_numero.getText().toString() + "5";
        input_numero.setText(contenido);
    }

    public void onClickButtonSeis(View view){
        contenido = input_numero.getText().toString() + "6";
        input_numero.setText(contenido);
    }

    public void onClickButtonSiete(View view){
        contenido = input_numero.getText().toString() + "7";
        input_numero.setText(contenido);
    }

    public void onClickButtonOcho(View view){
        contenido = input_numero.getText().toString() + "8";
        input_numero.setText(contenido);
    }

    public void onClickButtonNueve(View view){
        contenido = input_numero.getText().toString() + "9";
        input_numero.setText(contenido);
    }

    public void onClickButtonBorrar(View view){
        contenido = "";
        resultado = 0d;
        numero1 = 0d;
        numero2 = 0d;
        input_numero.setText(contenido);
        Toast.makeText(this, "Se borro", Toast.LENGTH_SHORT).show();
    }

    public void onClickButtonAbsoluto(View view){
        contenido = input_numero.getText().toString();

        if(!contenido.equals("")){
            resultado = Double.parseDouble(contenido);
            resultado = valorAbsoluto(resultado);
            input_numero.setText(String.valueOf(resultado));

            Toast.makeText(this, "Valor Absoluto", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickButtonRaiz(View view){
        contenido = input_numero.getText().toString();

        if(!contenido.equals("")){
            resultado = Double.parseDouble(contenido);
            resultado = Math.sqrt(resultado);
            input_numero.setText(String.valueOf(resultado));

            Toast.makeText(this, "Raiz Cuadrada", Toast.LENGTH_SHORT).show();
        }

    }

    public void onClickButtonCuadrado(View view){
        contenido = input_numero.getText().toString();

        if(!contenido.equals("")){
            resultado = Double.parseDouble(contenido);
            resultado *= resultado;
            input_numero.setText(String.valueOf(resultado));

            Toast.makeText(this, "Al cuadrado", Toast.LENGTH_SHORT).show();
        }

    }
    public void onClickButtonGetNumero1(View miView){
        contenido = input_numero.getText().toString();

        if(!contenido.equals(""))
            numero1 = Double.parseDouble(contenido);

        input_numero.setText("");
    }

    public void onClickButtonSuma(View miView){
        operacion = "+";
        Toast.makeText(this, "Mas", Toast.LENGTH_SHORT).show();
        onClickButtonGetNumero1(miView);
    }

    public void onClickButtonResta(View miView){
        operacion = "-";
        Toast.makeText(this, "Menos", Toast.LENGTH_SHORT).show();
        onClickButtonGetNumero1(miView);
    }

    public void onClickButtonMultiplica(View miView){
        operacion = "x";
        Toast.makeText(this, "Por", Toast.LENGTH_SHORT).show();
        onClickButtonGetNumero1(miView);
    }

    public void onClickButtonDivision(View miView){
        operacion = "/";
        Toast.makeText(this, "Entre", Toast.LENGTH_SHORT).show();
        onClickButtonGetNumero1(miView);
    }
    public void onClickButtonSignos(View view){
        contenido = input_numero.getText().toString();
        if(contenido.contains("-")){
            contenido = contenido.replace("-", "");

        }else{
            contenido = "-" + contenido;
        }
        input_numero.setText(contenido);

    }
    
    public void onClickIgual(View view) {
        numero2 = Double.parseDouble(input_numero.getText().toString());

        if (operacion.equals("+")) {
            resultado = numero1 + numero2;
        } else if (operacion.equals("-")) {
            resultado = numero1 - numero2;
        } else if (operacion.equals("x")) {
            resultado = numero1 * numero2;
        } else if(operacion.equals("/")){
            resultado = numero1 / numero2;
        } else{
            resultado = numero2;
        }

        input_numero.setText(String.valueOf(resultado));
    }

    public Double valorAbsoluto(Double resultado){
        return resultado >= 0 ? resultado : -resultado;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.action_about:
                return true;
            case R.id.action_help:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
