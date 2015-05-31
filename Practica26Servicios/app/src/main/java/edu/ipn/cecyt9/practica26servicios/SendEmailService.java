package edu.ipn.cecyt9.practica26servicios;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

public class SendEmailService extends Service {
    static final int DELAY = 10000;
    private NotificationManager manager;
    private static final int ID_NOTIFICACION_CREAR = 1;
    private boolean runFlag = false;
    private Notification notification;
    private PendingIntent pendingIntent;
    private long[] vibrate = {0, 100, 200, 300};
    private EnviarEmail enviarEmail;
    private LocationManager mLocationManager = null;
    private Enviar enviar;
    private static final int INTERVALO = 10000;
    private static final float DISTANCIA = 10f;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, INTERVALO,
                DISTANCIA, new Localizacion());

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);

        notification = new Notification(R.mipmap.ic_launcher,
                "Mensaje enviado", System.currentTimeMillis());

        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.vibrate = vibrate;

        notification.ledARGB = 0xff00ff00;
        notification.ledOnMS = 300;
        notification.ledOffMS = 1000;
        notification.flags |= Notification.FLAG_SHOW_LIGHTS;

        enviarEmail= new EnviarEmail();
        enviar = new Enviar(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        runFlag = true;
        if(!enviar.isAlive()){
            enviar.start();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        runFlag = false;
        enviar.interrupt();
        enviar = null;
    }

    public String ubicacionActual(){
        Location location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        String ubicacion = "No disponible";
        if(location != null){
            ubicacion = String.format("Localizacion actual \n Latitud: %s \n Longitud: %s",
                    location.getLatitude(), location.getLongitude());
        }
        return ubicacion;
    }

    private class Enviar extends Thread{
        Context context;
        int vez = 1;
        String texto;
        String titulo = "Enviando mi ubicacion por email";

        public Enviar(Context context){
            super("SendEmailService-EnviarThread");
            this.context = context;
        }

        @Override
        public void run() {
            SendEmailService emailService = SendEmailService.this;

            while (emailService.runFlag){
                texto = "Se envio mi ubicacion por " + (vez++) + " vez \n" + ubicacionActual();
                try {
                    notification.setLatestEventInfo(context, titulo, texto, pendingIntent);
                    manager.notify(ID_NOTIFICACION_CREAR, notification);

                    enviarEmail.enviar("reymysterio512@hotmail.com", titulo, texto);

                    Thread.sleep(DELAY);
                }catch (InterruptedException | MessagingException | UnsupportedEncodingException e){
                    emailService.runFlag = false;
                }
            }
        }
    }
    private class Localizacion implements LocationListener{

        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }
}
