package com.example.myapplication.service;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String token) {
        //token을 서버로 전송
        Log.e("tag", "Refreshed token: " + token);

        Task<String> instanceToken = FirebaseMessaging.getInstance().getToken();
        final String[] result = new String[1];
        instanceToken.addOnSuccessListener(new OnSuccessListener<String>() {
            @Override
            public void onSuccess(String token) {
                result[0] = instanceToken.getResult();

            }
        });

        super.onNewToken(token);
        Toast myToast = Toast.makeText(this.getApplicationContext(), result[0], Toast.LENGTH_SHORT);
        myToast.show();
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Toast myToast = Toast.makeText(this.getApplicationContext(), "메세지를 받았습니다.", Toast.LENGTH_SHORT);
        myToast.show();
    }

}
