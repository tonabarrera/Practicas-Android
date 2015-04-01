package ipn.edu.calculadora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private float num1, num2, resultado;
    private String contenido = "Resultado: ";
    private EditText input_numero1, input_numero2;
    private TextView text_resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_numero1 = (EditText) findViewById(R.id.input_number1);
        input_numero2 = (EditText) findViewById(R.id.input_number2);
        text_resultado = (TextView) findViewById(R.id.text_resultado);
    }
    public void onClickSuma(View view){
        resultado = 0;
        num1 = Float.parseFloat(input_numero1.getText().toString());
        num2 = Float.parseFloat(input_numero2.getText().toString());
        resultado = num1 + num2;
        text_resultado.setText(contenido + String.valueOf(resultado));

    }
    public void onClickResta(View view){
        resultado = 0;
        num1 = Float.parseFloat(input_numero1.getText().toString());
        num2 = Float.parseFloat(input_numero2.getText().toString());
        resultado = num1 - num2;
        text_resultado.setText(contenido + String.valueOf(resultado));

    }
    public void onClickMulti(View view){
        resultado = 0;
        num1 = Float.parseFloat(input_numero1.getText().toString());
        num2 = Float.parseFloat(input_numero2.getText().toString());
        resultado = num1 * num2;
        text_resultado.setText(contenido + String.valueOf(resultado));

    }
    public void onClickDivision(View view){
        resultado = 0;
        num1 = Float.parseFloat(input_numero1.getText().toString());
        num2 = Float.parseFloat(input_numero2.getText().toString());
        resultado = num1 / num2;
        text_resultado.setText(contenido + String.valueOf(resultado));

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
