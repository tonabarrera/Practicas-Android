package edu.ipn.cecyt9.practica6_intents;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private Uri uri;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAbrirPaginaWeb(View view)
    {
        uri = Uri.parse("http://coatl.cecyt9.ipn.mx/eoropeza/home.html");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onClickLlamadaTelefono(View view)
    {
        uri = Uri.parse("tel:59216686");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        startActivity(intent);
    }

    public void onClickGoogleMaps(View view)
    {
        uri = Uri.parse("geo:19.453659,-99.175298");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onClickStreetView(View view){
        //0 bearing 0 zoom tilt
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
        intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto: Prueba");
        intent.putExtra(Intent.EXTRA_TEXT, "Contenido del correo: Prueba");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"carlostonatihu@gmail.com"});
        startActivity(intent);
    }
    public void onClickMandarCorreoMejorado(View view)
    {
        Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Prueba");
        intent.putExtra(Intent.EXTRA_TEXT, "Este es el contenido de la prueba");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"carlostonatihu@gmail.com"});
        startActivity(Intent.createChooser(intent, "Selecciona una app:"));
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
            Toast.makeText(this, "Hecho por Carlos Tonatihu", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
