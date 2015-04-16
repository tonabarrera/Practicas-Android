package edu.ipn.cecyt9.practica04_reservas;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class SecondActivity extends ActionBarActivity {

    private String nombre = "", fecha = "", hora = "";
    private int noDePersonas = 0;
    TextView text_contenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text_contenido = (TextView) findViewById(R.id.text_contenido);
/*

        Bundle recibe = new Bundle();
        recibe = this.getIntent().getExtras();

        nombre = recibe.getString("nombre");
        noDePersonas = recibe.getInt("personas");
        fecha = recibe.getString("fecha");
        hora = recibe.getString("hora");
*/

        text_contenido.setText("Reservacion a nombre de:\n" + nombre
                + "\nNo. de personas: " + noDePersonas + "\nFecha: " + fecha
                + "\nHora: " + hora);
    }

    public void onClickButtonOtraReserva(View view){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}
