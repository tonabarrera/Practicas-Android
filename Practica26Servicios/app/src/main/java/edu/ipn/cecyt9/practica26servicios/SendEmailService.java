package edu.ipn.cecyt9.practica26servicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SendEmailService extends Service {
    public SendEmailService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
