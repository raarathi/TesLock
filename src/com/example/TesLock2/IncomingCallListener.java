package com.example.TesLock2;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class IncomingCallListener extends BroadcastReceiver {
    private Context mContext;
    private static final String TAG = "CustomBroadcastReceiver";

    TelephonyManager telephony;
    CustomPhoneStateListener customPhoneListener;

    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String state = extras.getString(TelephonyManager.EXTRA_STATE);
            Log.w("DEBUG", state);

            telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            customPhoneListener = new CustomPhoneStateListener();
            telephony.listen(customPhoneListener, PhoneStateListener.LISTEN_CALL_STATE);
            Bundle bundle = intent.getExtras();
            String phoneNr = bundle.getString("incoming_number");
        }
    }

    public class CustomPhoneStateListener extends PhoneStateListener {
        /*    private static final String TAG = "CustomPhoneStateListener";
            Handler handler = new Handler();
			
            @Override
            public void onCallStateChanged(int state, String incomingNumber) 
			ContentValues newValues = new ContentValues();
			newValues.put(ContactsContract.Contacts.SEND_TO_VOICEMAIL, 1);
            {
                switch (state) 
                {
                case TelephonyManager.CALL_STATE_RINGING:
                    {
                        newValues();
                    break;
                }
                super.onCallStateChanged(state, incomingNumber);
                telephony.listen(customPhoneListener, PhoneStateListener.LISTEN_NONE);
            }
        }*/
    }
}