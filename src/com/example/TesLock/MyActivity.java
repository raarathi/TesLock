package com.example.TesLock;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class  MyActivity extends Activity {

    private Button button;
    private Button.OnClickListener lock;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initializeApp();
}

    private void initializeApp() {
        button = (Button)findViewById(R.id.button);

        lock = new Button.OnClickListener() {
            public void onClick(View view)
            {
                GPSData gps = new GPSData();
            }
        };

        button.setOnClickListener(lock);

    }




}
