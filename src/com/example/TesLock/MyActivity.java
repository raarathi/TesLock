package com.example.TesLock;

import android.app.Activity;
import android.app.Notification;
import android.media.AudioManager;
import android.os.Bundle;
//import android.service.notification.NotificationListenerService;
//import android.service.notification.StatusBarNotification;
//import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.NotificationManager;
//import android.content.BroadcastReceiver;
import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.content.ReceiverCallNotAllowedException;
//import android.support.v4.app.NotificationCompat; **** No android.support ****

public class MyActivity extends Activity
{
private Button button;
private Button.OnClickListener lock;
private AudioManager mAudioManager;
private boolean mPhoneIsSilent;
private NotificationManager nm;

        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

            initializeApp();
            putPhoneOnSilent();
            blackFlashLight();
//            Log.d(“SilentModeApp”,“This is a test”);
        }

        /**
         * Initialized the application
         */
        private void initializeApp()
        {
            button = (Button)findViewById(R.id.button);
            lock = new Button.OnClickListener()
            {
                public void onClick(View view)
                {
                    //GPSData gps = new GPSData();
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
            nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            Notification note = new Notification();
            note.ledARGB = 0x0106000c;
            note.flags = Notification.FLAG_ONLY_ALERT_ONCE;
            note.priority = Notification.PRIORITY_HIGH;
            note.ledOnMS = 0;
            note.ledOffMS = 0;

            nm.notify(0, note);
        }
}





////package com.example.TesLock;
////
////import android.app.Activity;
////import android.os.Bundle;
////import android.service.notification.NotificationListenerService;
////import android.service.notification.StatusBarNotification;
////import android.view.View;
////import android.widget.Button;
//////import android.app.NotificationManager;
//////import android.content.BroadcastReceiver;
//////import android.content.Context;
//////import android.content.Intent;
//////import android.content.IntentFilter;
//////import android.content.ReceiverCallNotAllowedException
////// import android.support.v4.app.NotificationCompat; **** No android.support ****
////
////
////
////public class  MyActivity extends Activity {
////
////    private Button button;
////    private Button.OnClickListener lock;
////    private NotificationListenerService n;
////
////    /**
////     * Called when the activity is first created.
////     */
////    @Override
////    public void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.main);
////
////        n = new NotificationListenerService() {
////            @Override
////            public void onNotificationPosted(StatusBarNotification sbn) {
////                button.setText("Received");
////            }
////
////            @Override
////            public void onNotificationRemoved(StatusBarNotification sbn) {
////                button.setText("REMOVED");
////            }
////        };
////
////        initializeApp();
////
////    }
////
////    private void initializeApp() {
////        button = (Button) findViewById(R.id.button);
////        lock = new Button.OnClickListener() {
////
////            public void onClick(View view) {
////                //GPSData gps = new GPSData();
////                //button.setText("LOCKED");
////
////                //NotificationManager nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
////                //NotificationCompat.Builder ncomp = new NotificationCompat.Builder(this);
////
////                n.cancelAllNotifications();
////
////                //button.setText("LOCKED");
////
////            }
////        };
////
////        button.setOnClickListener(lock);
////    }
////
/////**        class NotificationReceiver extends BroadcastReceiver {
////            @Override
////            public void onReceive(Context context, Intent intent) {
////                String temp = intent.getStringExtra("notification_event") + "n" + button.getText();
////                button.setText(temp);
////            }
////        } */
////    }
//
//package com.example.TesLock;
//
//import android.app.Notification;
//import android.content.BroadcastReceiver; //allows communication between activity and service
//
//import android.app.Activity;
//import android.app.NotificationManager;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.os.Bundle;
////import android.support.v4.app.NotificationCompat;
//import android.view.View;
//import android.widget.*;
//import android.support.v4.app.NotificationCompat;
//
//public class MyActivity extends Activity {
//
//    private TextView txtView;
//    private NotificationReceiver nReceiver;
//    private NotificationManager nManager;
//    private Button button;
//    private Button.OnClickListener lock;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
//        //nReceiver = new NotificationReceiver();
//        //IntentFilter filter = new IntentFilter();
//
//        //registerReceiver(nReceiver,filter);
//
//        nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        NotificationCompat.Builder mBuilder =
//                new NotificationCompat.Builder(this)
//                        .setSmallIcon(null)
//                        .setContentTitle("")
//                        .setContentText("");
//
//    // Sets an ID for the notification
//        int mNotificationId = 001;
//    // Gets an instance of the NotificationManager service
//        NotificationManager mNotifyMgr =
//                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//    // Builds the notification and issues it.
//        mNotifyMgr.notify(mNotificationId, mBuilder.build());
//
//  //      while(true)
//   //     {
//            initializeApp();
////        }
//
//        //nManager.cancelAll();
//    }
//
//    /*@Override
//    protected void onDestroy() {
//        super.onDestroy();
//        unregisterReceiver(nReceiver);
//    }*/
//
//    private void initializeApp()
//    {
//        button = (Button)findViewById(R.id.button);
//        lock = new Button.OnClickListener()
//        {
//            public void onClick(View view){
//                nManager.notify();
//                GPSData gps = new GPSData();
//                nManager.cancelAll();
//
//            }
//        };
//
//        button.setOnClickListener(lock);
//
//    }
//
//}
//
//class NotificationReceiver extends BroadcastReceiver{
//
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        //String temp = intent.getStringExtra("notification_event") + "n" + txtView.getText();
//        //txtView.setText(temp);
//    }
//}