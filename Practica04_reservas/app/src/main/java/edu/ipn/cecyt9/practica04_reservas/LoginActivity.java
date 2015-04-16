package edu.ipn.cecyt9.practica04_reservas;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends ActionBarActivity {

    private EditText correo;
    private EditText contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        correo = (EditText) findViewById(R.id.input_email);
        contra = (EditText) findViewById(R.id.input_contra);
    }

    public void onClickEntrar(View view){
        String email = correo.getText().toString();
        String miContra = contra.getText().toString();
        if(email.equals("correo@gmail.com") && miContra.equals("123456")){
            Intent intent = new Intent(this, MainActivity.class);
            finish();
            startActivity(intent);
        } else{
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG).show();
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {
            Toast.makeText(this, "correo@gmail.com y 123456", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
