package com.example.TesLock2;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity
{
    private Button button;
    private Button.OnClickListener lock;
    private AudioManager mAudioManager;
    private NotificationManager nma;
    private NotificationListenerService nls;
    private SmsReceiver sr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        nma =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        initializeApp();
        putPhoneOnSilent();
        blackFlashLight();
        sr = new SmsReceiver();
    }

    /**
     * Initialized the application
     */
    private void initializeApp() {
        button = (Button) findViewById(R.id.button);
        lock = new Button.OnClickListener() {
            public void onClick(View view) {
                button.setText("LOCKED :)");
            }
        };
        button.setOnClickListener(lock);

    }

    /**
     * Checks to see if the phone is currently in silent mode.
     */
    private void putPhoneOnSilent()
    {
        mAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }

    /**
     * No LED light
     */
    private void blackFlashLight()
    {
        Notification note = new Notification();
        note.ledARGB = 0;
        note.flags = Notification.FLAG_ONLY_ALERT_ONCE;
        note.priority = Notification.PRIORITY_HIGH;
        note.ledOnMS = 0;
        note.ledOffMS = 1000;

        nma.notify(0 , note);
    }
}




//package com.example.TesLock;
//
//import android.app.Activity;
//import android.app.Notification;
//import android.content.Context;
//import android.media.AudioManager;
//import android.os.Bundle;
////import android.os.Handler;
////import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.app.NotificationManager;
////import android.content.Context;
//
//import java.io.IOException;
////import java.util.Scanner;
//
//
//public class MyActivity extends Activity
//{
//    private Button button;
//    private Button.OnClickListener lock;
//    private AudioManager mAudioManager;
//    private NotificationManager nm;
//    //private SmsReceiver sr;
//    //private ApacheClient ac;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
//
//            initializeApp();
//        putPhoneOnSilent();
//        blackFlashLight();
//        //sr = new SmsReceiver();
//    }
//
//    /**
//     * Initialized the application
//     */
//    private void initializeApp() {
//        //ac = new ApacheClient();
//        button = (Button) findViewById(R.id.button);
//        lock = new Button.OnClickListener() {
//            public void onClick(View view) {
//                //GPSData gps = new GPSData();
//                /*final Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    Scanner sc;
//
//                    @Override
//                    public void run()
//                    {
//                        // Do something after 5s = 5000ms
//                        try
//                        {
//                            String s = ac.getLocation();
//                            button.setText(s);
//                            button.setTextColor(1);
//                            //sc = new Scanner(s);
//                            //sc.useDelimiter("");
//                        }
//                        catch (IOException e)
//                        {
//                            //Log.d("DEBUG", "Error");
//                        }
//                    }
//                }, 7060);*/
//            }
//        };
//        button.setOnClickListener(lock);
//    }
//
//    /**
//     * Checks to see if the phone is currently in silent mode.
//     */
//    private void putPhoneOnSilent()
//    {
//        mAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
//    }
//
//    /**
//     * No LED light
//     */
//    private void blackFlashLight()
//    {
//        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        Notification note = new Notification();
//        note.ledARGB = 0x0106000c;
//        note.flags = Notification.FLAG_ONLY_ALERT_ONCE;
//        note.priority = Notification.PRIORITY_HIGH;
//        note.ledOnMS = 0;
//        note.ledOffMS = 1000;
//        nm.notify(0, note);
//    }
//}