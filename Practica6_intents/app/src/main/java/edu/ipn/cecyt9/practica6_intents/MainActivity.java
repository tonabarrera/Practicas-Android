/*
AUTOR: Barrera Pérez Carlos Tonatihu

VERSION: 2.0

DESCRIPCION: Esta aplicacion ejecuta diversos intents

OBSERVACIONES: En esta version en la parte de enviar email solo aparecen servicios de email y tambien ya funciona la street view a la escuela

COMPILACION: Se compila cuando se ejecuta

EJECUCION: Solo se da click en el boton 'run app', shift + F10 o click en la pestaña 'Run' y después
        click en 'Run App' y se selecciona el emulador o un dispositivo android.
*/

package edu.ipn.cecyt9.practica6_intents;
//importamos todo lo necesario
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Los siguientes metodos se ejecutan al pulsar el boton correspondiente
    public void onClickAbrirPaginaWeb(View view)
    {
        uri = Uri.parse("http://coatl.cecyt9.ipn.mx/eoropeza/home.html"); //Especificamos el url de la pagina
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent); //Disparamos el intent
    }

    public void onClickLlamadaTelefono(View view)
    {
        uri = Uri.parse("tel:59216686"); //Pasamos el numero que sera marcado como parte de la data
        Intent intent = new Intent(Intent.ACTION_CALL, uri); //Llamamos al itent para llamar
        startActivity(intent);
    }

    public void onClickGoogleMaps(View view)
    {
        uri = Uri.parse("geo:19.453659,-99.175298");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onClickStreetView(View view){
        //segun la documentacion de android de esta forma se accede a streetview
        uri = Uri.parse("google.streetview:cbll=19.453659,-99.175298&cbp=0,300,0,1,0");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    public void onClickTomarFoto(View view)
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    public void onClickMandarCorreo(View view)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        //Especificamos los campos del correo
        intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto: Prueba");
        intent.putExtra(Intent.EXTRA_TEXT, "Contenido del correo: Prueba");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"carlostonatihu@gmail.com"});
        startActivity(intent);
    }
    public void onClickMandarCorreoMejorado(View view)
    {
        Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        intent.setType("message/rfc822"); //se pasa este tipo de data que solo entienden los servicios de correo
        intent.putExtra(Intent.EXTRA_SUBJECT, "Prueba");
        intent.putExtra(Intent.EXTRA_TEXT, "Este es el contenido de la prueba");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"carlostonatihu@gmail.com"});
        startActivity(Intent.createChooser(intent, "Selecciona una app:"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_about) {
            Toast.makeText(this, "Hecho por Carlos Tonatihu", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
