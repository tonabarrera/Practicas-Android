/*
AUTOR: Barrera Pérez Carlos Tonatihu

VERSION: 2.0

DESCRIPCION: Este programa junta la practica uno y la practica dos, que en conjunto funcionan como
        una calculadora muy elemental.

OBSERVACIONES: La primera version, solo eran operaciones basicas (suma,
        resta, multiplicacion, division), en esta version se incluyen la raiz cuadrada, elevar al
        cuadrado y calcular el valor absoluto. El resultado se imprime en un EditText

COMPILACION: Se conpila cuando se ejecuta

EJECUCION: Solo se da click en el boton 'run app', shift + F10 o click en la pestaña 'Run' y después
        click en 'Run App' y se selecciona el emulador o un dispositivo android.
*/

package edu.cecyt9.ipn.practica1_calculadora; //Nombre del paquete

//Librerias que necesitamos
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//Esta es nuestra clase principal (Una actividad) que ereda de ActionBarActivity
public class MainActivity extends ActionBarActivity {
    //Nuestras variables que utilizaremos
    private EditText input_numero;
    private String contenido = "";
    private Double resultado = 0d, numero1 = 0d, numero2 = 0d;
    private String operacion = "";
    //Esta es el primer metodo que se ejecuta cuando corremos nuestra app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_numero = (EditText) findViewById(R.id.input_numero);
    }
    //Con todos estos metodos recupero lo que hay en el EditText y el numero indicado cuando se hace
    //click en el boton que tiene este metodo
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
    //Con este metodo limpiamos todos nuestros campos cuando se da click al boton que lo tiene asignado
    public void onClickButtonBorrar(View view){
        contenido = "";
        resultado = 0d;
        numero1 = 0d;
        numero2 = 0d;
        input_numero.setText(contenido);
        Toast.makeText(this, "Se borro", Toast.LENGTH_SHORT).show();
    }
    //Calcula el valor absoluto
    public void onClickButtonAbsoluto(View view){
        contenido = input_numero.getText().toString();
        //Para evitar errores se checa si tiene algo
        if(!contenido.equals("")){
            resultado = Double.parseDouble(contenido);
            resultado = valorAbsoluto(resultado); //Se puede remplazar por Math.abs(resultado)
            input_numero.setText(String.valueOf(resultado));

            Toast.makeText(this, "Valor Absoluto", Toast.LENGTH_SHORT).show(); //Un mensaje para el usuario
        }
    }
    //Calcula la raiz de un numero
    public void onClickButtonRaiz(View view){
        contenido = input_numero.getText().toString();

        if(!contenido.equals("")){
            resultado = Double.parseDouble(contenido);
            resultado = Math.sqrt(resultado);
            input_numero.setText(String.valueOf(resultado));

            Toast.makeText(this, "Raiz Cuadrada", Toast.LENGTH_SHORT).show();
        }

    }

    //recuperamos el primer numero
    public void onClickButtonGetNumero1(View miView){
        contenido = input_numero.getText().toString();

        if(!contenido.equals(""))
            numero1 = Double.parseDouble(contenido);

        input_numero.setText("");
    }
    //Guardamos que operacion se hace para despues evaluar y hacer la operacion adecuada
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

    public void onClickButtonPotencia(View view){
        operacion = "potencia";
        Toast.makeText(this, "Potencia", Toast.LENGTH_SHORT).show();
        onClickButtonGetNumero1(view);

    }
    //Agrega o quita el signo negativo a el numero
    public void onClickButtonSignos(View view){
        contenido = input_numero.getText().toString();
        if(contenido.contains("-")){ //Checamos si tiene el signo negativo
            contenido = contenido.replace("-", ""); //Si lo tiene lo quitamos

        }else{
            contenido = "-" + contenido;
        }
        input_numero.setText(contenido);

    }
    //Controlamos que operacion se realiza cuando se da click en el boton igual
    public void onClickIgual(View view) {
        contenido = input_numero.getText().toString();
        if(!contenido.equals("")){
            numero2 = Double.parseDouble(contenido);
        }

        if (operacion.equals("+")) {
            resultado = numero1 + numero2;
        } else if (operacion.equals("-")) {
            resultado = numero1 - numero2;
        } else if (operacion.equals("x")) {
            resultado = numero1 * numero2;
        } else if(operacion.equals("/")){
            resultado = numero1 / numero2;
        } else if(operacion.equals("potencia")){
            resultado = Math.pow(numero1, numero2);
        } else {
            resultado = numero2;
        }

        input_numero.setText(String.valueOf(resultado));
    }
    //Este metodo calcula el valor absoluto de un numero
    public Double valorAbsoluto(Double resultado){
        return resultado >= 0 ? resultado : -resultado; //usamos el operador terneario para rapido
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
                Toast.makeText(this, "Programa hecho por Barrera Pérez Carlos Tonatihu 6IM7", Toast.LENGTH_LONG).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
