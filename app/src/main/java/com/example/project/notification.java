package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;

public class notification extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }
    public void showNotification()
    {
        NotificationChannel notificationChannel = new NotificationChannel(
            "CHANNEL_ONE","Notification Channel",
            NotificationManager.IMPORTANCE_DEFAULT);
        notificationChannel.setDescription("Example");
        NotificationManager manager= getSystemService(NotificationManager.class);
        manager.createNotificationChannel(notificationChannel);
        Notification notification=new NotificationCompat
                .Builder(this,"CHANNEL_ONE")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("title")
                .setContentText("text")
                .build();
        manager.notify(1,notification);
    }


}