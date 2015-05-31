package edu.ipn.cecyt9.practica26servicios;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

public class SendEmailService extends Service {
    private static final String TAG = SendEmailService.class.getSimpleName();
    static final int DELAY = 10000;
    private NotificationManager manager;
    private static final int ID_NOTIFICACION_CREAR = 1;
    private boolean runFlag = false;
    private Notification notification;
    private PendingIntent pendingIntent;
    private long[] vibrate = {0, 100, 200, 300};
    EnviarEmail enviarEmail;

    private Enviar enviar;

    public SendEmailService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreated");

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

        Log.d(TAG, "onStartCommand");
        runFlag = true;
        if(!enviar.isAlive()){
            enviar.start();
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroyed");
        runFlag = false;
        enviar.interrupt();
        enviar = null;
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
                Log.d(TAG, "EnviarThread corriendo");
                texto = "Se envio mi ubicacion por " + (vez++) + " vez";

                try {
                    notification.setLatestEventInfo(context, titulo, texto, pendingIntent);
                    manager.notify(ID_NOTIFICACION_CREAR, notification);

                    enviarEmail.enviar("reymysterio512@gmail.com", titulo, texto);

                    Thread.sleep(DELAY);

                }catch (InterruptedException | MessagingException | UnsupportedEncodingException e){
                    Log.d(TAG, e.toString());
                    emailService.runFlag = false;
                }
            }
        }
    }
}
