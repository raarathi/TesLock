package com.example.TesLock;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
//import android.service.notification.NotificationListenerService;
//import android.service.notification.StatusBarNotification;
//import android.util.Log;
import android.telephony.SmsManager;
import android.telephony.gsm.SmsMessage;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.NotificationManager;
//import android.content.BroadcastReceiver;
import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.content.ReceiverCallNotAllowedException;
//import android.support.v4.app.NotificationCompat; **** No android.support ****
import android.telephony.TelephonyManager;
//import android.telephony.SmsManager;
import android.widget.Toast;


public class MyActivity extends Activity {
    private Button button;
    private Button.OnClickListener lock;
    private AudioManager mAudioManager;
    private boolean mPhoneIsSilent;
    private NotificationManager nm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        //smsManager = (SmsManager)getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        //smsManager = SmsManager.getDefault();

        initializeApp();
        putPhoneOnSilent();
        blackFlashLight();
//            Log.d(“SilentModeApp”,“This is a test”);
    }

    /**
     * Initialized the application
     */
    private void initializeApp() {
        button = (Button) findViewById(R.id.button);
        lock = new Button.OnClickListener() {
            public void onClick(View view) {
                //GPSData gps = new GPSData();
                button.setText("LOCKED :)");
            }
        };
        button.setOnClickListener(lock);
    }

    /**
     * Checks to see if the phone is currently in silent mode.
     */
    private void putPhoneOnSilent() {
        mAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }

    /**
     * No LED light
     */
    private void blackFlashLight() {
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification note = new Notification();
        note.ledARGB = 0x0106000c;
        note.flags = Notification.FLAG_ONLY_ALERT_ONCE;
        note.priority = Notification.PRIORITY_HIGH;
        note.ledOnMS = 0;
        note.ledOffMS = 1000;

        nm.notify(0, note);
    }
}