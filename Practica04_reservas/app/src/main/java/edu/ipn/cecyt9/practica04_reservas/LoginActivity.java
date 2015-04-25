/*
AUTOR: Barrera Pérez Carlos Tonatihu

VERSION: 2.0

DESCRIPCION: Esta actividad funciona como login

OBSERVACIONES: Si los datos ingresados son correctos se cierra esta actividad y se avanza a la siguiente

COMPILACION: Se conpila cuando se ejecuta

EJECUCION: Solo se da click en el boton 'run app', shift + F10 o click en la pestaña 'Run' y después
        click en 'Run App' y se selecciona el emulador o un dispositivo android.
*/

package edu.ipn.cecyt9.practica04_reservas;
//importamos lo necesario
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends ActionBarActivity {
    //Declaramos las variables
    private EditText correo;
    private EditText contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //inicializamos nuestros elementos
        correo = (EditText) findViewById(R.id.input_email);
        contra = (EditText) findViewById(R.id.input_contra);
    }
    //Se ejecuta cuando se da click al boton iniciar sesion
    public void onClickEntrar(View view){
        //Se recuperan los valores de los input
        String email = correo.getText().toString();
        String miContra = contra.getText().toString();
        //Si los datos estan bien se ejecuta una nueva actividad
        if(email.equals("correo@gmail.com") && miContra.equals("123456")){
            //Creamos un intent con el que se dispara la actividad
            Intent intent = new Intent(this, MainActivity.class);
            finish(); //esto termina esta actividad
            startActivity(intent); //Se dispara la siguiente actividad
        } else{
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG).show(); //Se muestra si los datos son incorrectos
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //Un mensaje por si se olvidan los campos
        if (id == R.id.action_help) {
            Toast.makeText(this, "correo@gmail.com y 123456", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
