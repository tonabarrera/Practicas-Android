package edu.cecyt9.ipn.practica1_calculadora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    private EditText input_numero;
    private String contenido = "";
    private Double resultado = 0d;
    private final static String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        input_numero.setText(contenido);
    }
    public void onClickButtonAbsoluto(View view){
        contenido = input_numero.getText().toString();
        resultado = Double.parseDouble(contenido);
        resultado = valorAbsoluto(resultado);
        input_numero.setText(String.valueOf(resultado));
    }
    public void onClickButtonRaiz(View view){
        resultado = Double.parseDouble(input_numero.getText().toString());
        resultado = Math.sqrt(resultado);
        input_numero.setText(String.valueOf(resultado));
    }
    public void onClickButtonCuadrado(View view){
        resultado = Double.parseDouble(input_numero.getText().toString());
        resultado *= resultado;
        input_numero.setText(String.valueOf(resultado));
    }
    public Double valorAbsoluto(Double resultado){
        return resultado >= 0 ? resultado : -resultado;
    }
    public void limpiar(){
        contenido = "";
        resultado = 0d;
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
