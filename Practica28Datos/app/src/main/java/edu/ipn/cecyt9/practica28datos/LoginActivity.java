package edu.ipn.cecyt9.practica28datos;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity {
    private EditText correo;
    private EditText contra;
    private DBOperations operaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        correo = (EditText) findViewById(R.id.input_email);
        contra = (EditText) findViewById(R.id.input_contra);
        operaciones = new DBOperations(this);
    }

    public void onClickEntrar(View view){
        String email = correo.getText().toString().trim();
        String miContra = contra.getText().toString().trim();

        if(operaciones.getUser(email, miContra)){
            //Creamos un intent con el que se dispara la actividad
            Intent intent = new Intent(this, MainActivity.class);
            finish(); //esto termina esta actividad
            startActivity(intent); //Se dispara la siguiente actividad
        } else{
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG).show(); //Se muestra si los datos son incorrectos
        }
    }
    public void onClickRegistro(View view){
        String email = correo.getText().toString();
        String miContra = contra.getText().toString();
        ContentValues valores = new ContentValues();
        if(!email.equals("") && !miContra.equals("")){
            valores.put(DBHelper.C_EMAIL, email);
            valores.put(DBHelper.C_PASSWORD, miContra);
            operaciones.insert(valores);
            Toast.makeText(this, "Se registro", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Datos Incorrectos ", Toast.LENGTH_SHORT).show();
        }

    }

}
