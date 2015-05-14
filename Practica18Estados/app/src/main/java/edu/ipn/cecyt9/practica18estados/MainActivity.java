package edu.ipn.cecyt9.practica18estados;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TimePicker;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnSeekBarChangeListener,
        OnClickListener, OnDateSetListener, OnTimeSetListener {

    EditText nombre, cantidadDolar;
    TextView cuantasPersonas, texto;
    Button fecha, hora;
    SeekBar barraPersonas;

    SimpleDateFormat horaFormato, fechaFormato;
    MediaPlayer mp;

    String nombreReserva = "";
    String numPersonas = "";
    String fechaSel = "", horaSel = "";
    Date fechaConv;
    String cuantasPersonasFormat = "";
    int personas = 1; // Valor por omision, al menos 1 persona tiene que reservar

    Calendar calendario;

    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

//		mp = MediaPlayer.create(this, R.raw.audio);
//		mp.start();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.textViewText);
        cantidadDolar = (EditText) findViewById(R.id.editTextCantidad);

        cuantasPersonas = (TextView) findViewById(R.id.cuantasPersonas);
        barraPersonas = (SeekBar) findViewById(R.id.personas);

        fecha = (Button) findViewById(R.id.fecha);
        hora = (Button) findViewById(R.id.hora);

        barraPersonas.setOnSeekBarChangeListener(this);

        nombre = (EditText) findViewById(R.id.nombre);

        cuantasPersonasFormat = cuantasPersonas.getText().toString();
        // cuantasPersonasFormat = "personas: %d";
        cuantasPersonas.setText("Personas: 1"); // condicion inicial

        // Para seleccionar la fecha y la hora
        Calendar fechaSeleccionada = Calendar.getInstance();
        fechaSeleccionada.set(Calendar.HOUR_OF_DAY, 12); // hora inicial
        fechaSeleccionada.clear(Calendar.MINUTE); // 0
        fechaSeleccionada.clear(Calendar.SECOND); // 0

        // formatos de la fecha y hora
        fechaFormato = new SimpleDateFormat(fecha.getText().toString());
        horaFormato = new SimpleDateFormat("HH:mm");
        // horaFormato = new SimpleDateFormat(hora.getText().toString());

        // La primera vez mostramos la fecha actual
        Date fechaReservacion = fechaSeleccionada.getTime();
        fechaSel = fechaFormato.format(fechaReservacion);
        fecha.setText(fechaSel); // fecha en el

        horaSel = horaFormato.format(fechaReservacion);
        // boton
        hora.setText(horaSel); // hora en el boton

        // Otra forma de ocupar los botones
        fecha.setOnClickListener(this);
        hora.setOnClickListener(this);

    }

    @Override protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
//		mp.start();
    }

    @Override protected void onPause() {
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        super.onPause();
//		mp.pause();
    }

    @Override protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override protected void onDestroy() {
//	    mp.stop();
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();

    }

    public void lanzarAcercaDe(View view){
        Intent i = new Intent(this, AcercaDeActivity.class);
        startActivity(i);
    }

    public void pulso(View view)
    {
        contador++;
        texto.setText(String.valueOf(contador));
    }

    //El codigo que se modifico es este
    @Override
    protected void onSaveInstanceState(Bundle guardarEstado) {
        super.onSaveInstanceState(guardarEstado);
        //Cuardamos todos los elementos que se borran en nuestro bundle
        guardarEstado.putInt("contador", contador);
        guardarEstado.putString("fecha", fechaSel);
        guardarEstado.putString("hora", horaSel);
    }

    @Override
    protected void onRestoreInstanceState(Bundle recEstado) {
        super.onRestoreInstanceState(recEstado);
        //Recuperamos nuestros datos
        contador = recEstado.getInt("contador");
        fechaSel = recEstado.getString("fecha");
        horaSel = recEstado.getString("hora");
        //Los asignamos a nuestros campos
        fecha.setText(fechaSel);
        hora.setText(horaSel);
        texto.setText(String.valueOf(contador));
    }


    @Override
    public void onProgressChanged(SeekBar barra, int progreso, boolean delUsuario) {

        numPersonas = String.format(cuantasPersonasFormat,
                barraPersonas.getProgress() + 1);
        personas = barraPersonas.getProgress() + 1; // este es el valor que se
        // guardara en la BD
        // Si no se mueve la barra, enviamos el valor personas = 1
        cuantasPersonas.setText(numPersonas);
    }

    @Override
    public void onStartTrackingTouch(SeekBar arg0) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar arg0) {
    }

    @Override
    public void onClick(View v) {
        if (v == fecha) {
            Calendar calendario = parseCalendar(fecha.getText(), fechaFormato);
            new DatePickerDialog(this, this, calendario.get(Calendar.YEAR),
                    calendario.get(Calendar.MONTH),
                    calendario.get(Calendar.DAY_OF_MONTH)).show();
        } else if (v == hora) {
            Calendar calendario = parseCalendar(hora.getText(), horaFormato);
            new TimePickerDialog(this, this,
                    calendario.get(Calendar.HOUR_OF_DAY),
                    calendario.get(Calendar.MINUTE), false) // /true = 24 horas
                    .show();
        }
    }

    private Calendar parseCalendar(CharSequence text, SimpleDateFormat fechaFormat2) {
        try {
            fechaConv = fechaFormat2.parse(text.toString());
        } catch (ParseException e) { // import java.text.ParsedExc
            throw new RuntimeException(e);
        }
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fechaConv);
        return calendario;
    }

    @Override
    public void onDateSet(DatePicker picker, int anio, int mes, int dia) {
        calendario = Calendar.getInstance();
        calendario.set(Calendar.YEAR, anio);
        calendario.set(Calendar.MONTH, mes);
        calendario.set(Calendar.DAY_OF_MONTH, dia);

        fechaSel = fechaFormato.format(calendario.getTime());
        fecha.setText(fechaSel);

    }

    public void onTimeSet(TimePicker picker, int horas, int minutos) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, horas);
        calendar.set(Calendar.MINUTE, minutos);

        horaSel = horaFormato.format(calendar.getTime());
        hora.setText(horaSel);
    }

    public void reserva(View v) {
        Intent envia = new Intent(this, SecondActivity.class);
        Bundle datos = new Bundle();
        datos.putString("nombre", nombre.getText().toString().trim());
        datos.putInt("personas", personas);
        datos.putString("fecha", fechaSel);
        datos.putString("hora", horaSel);
        datos.putInt("dolares", (Integer.parseInt(cantidadDolar.getText().toString().trim()) / 15));
        envia.putExtras(datos);
        finish();
        startActivity(envia);
    }
}

