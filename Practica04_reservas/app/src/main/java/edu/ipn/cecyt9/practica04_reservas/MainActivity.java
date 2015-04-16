package edu.ipn.cecyt9.practica04_reservas;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends ActionBarActivity implements SeekBar.OnSeekBarChangeListener,
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private EditText input_nombre;
    private TextView text_personas;
    private Button btn_fecha, btn_hora;
    private SeekBar barraPersonas;

    private SimpleDateFormat horaFormato, fechaFormato;

    private String numPersonas = "";
    private String fechaSel = "", horaSel = "";
    private Date fechaConv;
    private String cuantasPersonasFormat = "";
    private int personas = 1;

    private Calendar calendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_nombre = (EditText) findViewById(R.id.input_nombre);
        text_personas = (TextView) findViewById(R.id.text_personas);
        barraPersonas = (SeekBar) findViewById(R.id.seekbar_personas);
        btn_fecha = (Button) findViewById(R.id.btn_fecha);
        btn_hora = (Button) findViewById(R.id.btn_hora);

        barraPersonas.setOnSeekBarChangeListener(this);

        cuantasPersonasFormat = text_personas.getText().toString();
        numPersonas = String.format(cuantasPersonasFormat, personas);
        text_personas.setText(numPersonas);

        Calendar fechaSeleccionada = Calendar.getInstance();

        fechaFormato = new SimpleDateFormat("dd/MM/yy");
        horaFormato = new SimpleDateFormat("HH:mm");

        Date fechaReservacion = fechaSeleccionada.getTime();
        fechaSel = fechaFormato.format(fechaReservacion);
        btn_fecha.setText(fechaSel);

        horaSel = horaFormato.format(fechaReservacion);
        btn_hora.setText(horaSel);

    }

    @Override
    public void onProgressChanged(SeekBar barra, int progreso, boolean delUsuario) {
        personas = barraPersonas.getProgress() + 1;
        numPersonas = String.format(cuantasPersonasFormat, personas);
        text_personas.setText(numPersonas);
    }

    @Override
    public void onStartTrackingTouch(SeekBar barra) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar barra) {
    }

    public void onClickBotones(View v) {
        if (v == btn_fecha) {
            Calendar calendario = parseCalendar(btn_fecha.getText(), fechaFormato);
            new DatePickerDialog(this, this, calendario.get(Calendar.YEAR),
                    calendario.get(Calendar.MONTH),
                    calendario.get(Calendar.DAY_OF_MONTH)).show();
        } else if (v == btn_hora) {
            Calendar calendario = parseCalendar(btn_hora.getText(), horaFormato);
            new TimePickerDialog(this, this,
                    calendario.get(Calendar.HOUR_OF_DAY),
                    calendario.get(Calendar.MINUTE), false).show();
        }
    }

    private Calendar parseCalendar(CharSequence text, SimpleDateFormat fechaFormat2) {
        try {
            fechaConv = fechaFormat2.parse(text.toString());
        } catch (ParseException e) {
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
        btn_fecha.setText(fechaSel);

    }

    public void onTimeSet(TimePicker picker, int horas, int minutos) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, horas);
        calendar.set(Calendar.MINUTE, minutos);

        horaSel = horaFormato.format(calendar.getTime());
        btn_hora.setText(horaSel);
    }

    public void onClickReserva(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        Bundle datos = new Bundle();
        datos.putString("nombre", input_nombre.getText().toString().trim());
        datos.putInt("numeroPersonas", personas);
        datos.putString("fecha", fechaSel);
        datos.putString("hora", horaSel);
        intent.putExtras(datos);
        startActivity(intent);
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
            Toast.makeText(this, "Hecho por Carlos Tonatihu", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
