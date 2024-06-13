package com.example.myapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.myapplication.service.AlarmIntentService;

public class AlarmBroadcastReceiver extends BroadcastReceiver {

    public AlarmBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent alarmIntentServiceIntent = new Intent(context, AlarmIntentService.class);
        context.startActivity(alarmIntentServiceIntent);
    }
}
