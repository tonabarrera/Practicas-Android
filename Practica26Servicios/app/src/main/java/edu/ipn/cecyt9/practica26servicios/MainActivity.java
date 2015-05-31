package edu.ipn.cecyt9.practica26servicios;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStartMusic(View view){
        startService(new Intent(this, MusicService.class));
    }

    public void onClickStopMusic(View view){
        stopService(new Intent(this, MusicService.class));
    }

    public void onClickStartEmail(View view){
        startService(new Intent(this, SendEmailService.class));
    }

    public void onClickStopEmail(View view){
        stopService(new Intent(this, SendEmailService.class));
    }
}
