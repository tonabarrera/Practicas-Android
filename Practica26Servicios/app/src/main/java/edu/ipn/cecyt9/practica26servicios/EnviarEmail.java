package edu.ipn.cecyt9.practica26servicios;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by USER on 30/05/2015.
 */
public class EnviarEmail{
    private String user = "strongfitapp@gmail.com";
    private String password = "";
    private Session sesion;

    public EnviarEmail() {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        sesion = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
    }

    public void enviar(String email, String titulo, String texto) throws UnsupportedEncodingException, MessagingException {
        Message mensaje = new MimeMessage(sesion);
        mensaje.setFrom(new InternetAddress("strongfitapp@gmail.com", "Carlos Tonatihu"));
        mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        mensaje.setSubject(titulo);
        mensaje.setText(texto);
        Transport.send(mensaje);
    }
}
