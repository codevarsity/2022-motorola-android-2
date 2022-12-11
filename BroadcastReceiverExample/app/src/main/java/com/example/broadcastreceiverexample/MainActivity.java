package com.example.broadcastreceiverexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyCustomReceiver receiver = new MyCustomReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.broadcastreceiverexample.CUSTOM");
        registerReceiver(receiver, filter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public void send(View view) {
        Intent intent = new Intent("com.example.broadcastreceiverexample.CUSTOM");
        sendBroadcast(intent);
    }
}